package com.switchfully.parkshark;

import com.switchfully.parkshark.domain.division.Division;
import com.switchfully.parkshark.domain.division.DivisionRepository;
import com.switchfully.parkshark.domain.exceptions.DivisionDoesNotExistException;
import com.switchfully.parkshark.service.division.CreateDivisionDTO;
import com.switchfully.parkshark.service.division.DivisionDTO;
import com.switchfully.parkshark.service.services.DivisionService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@SpringBootTest
class DivisionServiceIntegrationTest {

    @Autowired
    private DivisionService divisionService;

    @Autowired
    private DivisionRepository divisionRepository;

    @Test
    @DirtiesContext
    void whenCreateDivisionDtoIsSaved_checkThatReturnSDivisionDto() {
        CreateDivisionDTO createDivisionDTO = new CreateDivisionDTO("bla", "balbla", "blabklaqsfdq");
        DivisionDTO divisionDto = divisionService.saveDivision(createDivisionDTO);
        assertThat(divisionDto.getDirector()).isEqualTo(createDivisionDTO.getDirector());
        assertThat(divisionDto.getName()).isEqualTo(createDivisionDTO.getName());
        assertThat(divisionDto.getOriginalName()).isEqualTo(createDivisionDTO.getOriginalName());
    }

    @Test
    @DirtiesContext
    void getAllDivisions() {
        // Given
        divisionRepository.save(new Division("bla", "balbla", "blabklaqsfdq"));
        // When
        List<DivisionDTO> divisionDTOS = divisionService.getAllDivisions();
        // Then
        assertThat(divisionDTOS).hasSize(1);
    }

    @Test
    @DirtiesContext
    void createSubDivision() {
        // Given
        Division parentDivision = divisionRepository.save(new Division("bla", "balbla", "blabklaqsfdq"));
        Division subDivision = divisionRepository.save(new Division("bla", "balbla", "blabklaqsfdq"));
        // When
        divisionService.assignSubDivision(parentDivision.getId(), subDivision.getId());
        // Then
        assertThat(divisionRepository.findById(subDivision.getId()).getParentDivision()).isEqualTo(parentDivision);
    }

    @Test
    @DirtiesContext
    void createSubDivision_givenWrongParentId_thenThrowDivisionDoesNotExistException() {
        assertThatThrownBy(() -> divisionService.assignSubDivision(1, 2))
                .isInstanceOf(DivisionDoesNotExistException.class)
                .hasMessage("Division with id: 1 does not exist");
    }

    @Test
    @DirtiesContext
    void createSubDivision_givenWrongSubId_thenThrowDivisionDoesNotExistException() {
        Division parentDivision = divisionRepository.save(new Division("bla", "balbla", "blabklaqsfdq"));
        assertThatThrownBy(() -> divisionService.assignSubDivision(parentDivision.getId(), 2))
                .isInstanceOf(DivisionDoesNotExistException.class)
                .hasMessage("Division with id: 2 does not exist");
    }

    @AfterEach
    void breakDown() {
        divisionRepository.deleteAll();
    }
}