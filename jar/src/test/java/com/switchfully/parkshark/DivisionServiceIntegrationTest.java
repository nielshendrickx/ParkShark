package com.switchfully.parkshark;

import com.switchfully.parkshark.domain.division.Division;
import com.switchfully.parkshark.domain.division.DivisionRepository;
import com.switchfully.parkshark.domain.exceptions.DivisionDoesNotExistException;
import com.switchfully.parkshark.service.division.CreateDivisionDTO;
import com.switchfully.parkshark.service.division.DivisionDTO;
import com.switchfully.parkshark.service.services.DivisionService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class DivisionServiceIntegrationTest {

    @Autowired
    private DivisionService divisionService;

    @Autowired
    private DivisionRepository divisionRepository;

    @Test
    void whenCreateDivisionDtoIsSaved_checkThatReturnSDivisionDto() {
        CreateDivisionDTO createDivisionDTO = new CreateDivisionDTO("bla", "balbla", "blabklaqsfdq");
        DivisionDTO divisionDto = divisionService.saveDivision(createDivisionDTO);
        Assertions.assertThat(divisionDto.getDirector()).isEqualTo(createDivisionDTO.getDirector());
        Assertions.assertThat(divisionDto.getName()).isEqualTo(createDivisionDTO.getName());
        Assertions.assertThat(divisionDto.getOriginalName()).isEqualTo(createDivisionDTO.getOriginalName());
    }

    @Test
    void getAllDivisions() {
        // Given
        divisionRepository.save(new Division("bla", "balbla", "blabklaqsfdq"));
        // When
        List<DivisionDTO> divisionDTOS = divisionService.getAllDivisions();
        // Then
        Assertions.assertThat(divisionDTOS).hasSize(1);
    }

    @Test
    void createSubDivision() {
        // Given
        Division parentDivision = divisionRepository.save(new Division("bla", "balbla", "blabklaqsfdq"));
        Division subDivision = divisionRepository.save(new Division("bla", "balbla", "blabklaqsfdq"));
        // When
        divisionService.assignSubDivision(parentDivision.getId(), subDivision.getId());
        // Then
        Assertions.assertThat(divisionRepository.findById(subDivision.getId()).get().getParentDivision()).isEqualTo(parentDivision);
    }

    @Test
    void createSubDivision_givenWrongParentId_thenThrowDivisionDoesNotExistException() {
        Assertions.assertThatThrownBy(() -> divisionService.assignSubDivision(1, 2))
                .isInstanceOf(DivisionDoesNotExistException.class)
                .hasMessage("Division with id: 1 does not exist");
    }

    @Test
    void createSubDivision_givenWrongSubId_thenThrowDivisionDoesNotExistException() {
        Division parentDivision = divisionRepository.save(new Division("bla", "balbla", "blabklaqsfdq"));
        Assertions.assertThatThrownBy(() -> divisionService.assignSubDivision(parentDivision.getId(), 2))
                .isInstanceOf(DivisionDoesNotExistException.class)
                .hasMessage("Division with id: 2 does not exist");
    }

    @AfterEach
    void breakDown() {
        divisionRepository.deleteAll();
    }
}