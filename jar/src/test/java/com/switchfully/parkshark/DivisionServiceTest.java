package com.switchfully.parkshark;

import com.switchfully.parkshark.service.division.CreateDivisionDTO;
import com.switchfully.parkshark.service.division.DivisionDTO;
import com.switchfully.parkshark.service.division.DivisionService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class DivisionServiceTest {

    @Autowired
    private DivisionService divisionService;

    @Test
    void whenCreateDivisionDtoIsSaved_checkThatReturnSDivisionDto() {
        CreateDivisionDTO createDivisionDTO = new CreateDivisionDTO("bla", "balbla", "blabklaqsfdq");
        DivisionDTO divisionDto = divisionService.saveDivision(createDivisionDTO);
        Assertions.assertThat(divisionDto.getDirector()).isEqualTo(createDivisionDTO.getDirector());
        Assertions.assertThat(divisionDto.getName()).isEqualTo(createDivisionDTO.getName());
        Assertions.assertThat(divisionDto.getOriginalName()).isEqualTo(createDivisionDTO.getOriginalName());
    }
}