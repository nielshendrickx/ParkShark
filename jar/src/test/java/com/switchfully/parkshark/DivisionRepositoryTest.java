package com.switchfully.parkshark;


import com.switchfully.parkshark.domain.division.Division;
import com.switchfully.parkshark.domain.division.DivisionRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;




@DataJpaTest
class DivisionRepositoryTest {

    @Autowired
    private DivisionRepository divisionRepository;

    @Test
    void saveDivision(){
        Division division = new Division("bla","bla","bla");
        Division actualValue = divisionRepository.save(division);
        Assertions.assertThat(actualValue).isEqualTo(division);
        Assertions.assertThat(divisionRepository.count()).isEqualTo(1);
    }

    @Test
    void saveThreeDivisions_checkThatSizeIs3() {
        Division division = new Division("bla", "bla", "bla");
        Division division2 = new Division("bla", "bla", "bla");
        Division division3 = new Division("bla", "bla", "bla");
        List<Division> divisionList = Arrays.asList(division,division2,division3);
        divisionRepository.saveAll(divisionList);
        Assertions.assertThat(divisionRepository.count()).isEqualTo(3);
    }

 /*   @Test
    void saveThreeDivisions_checkThatIdOfThirdIsRight() {
        Division division = new Division("bla", "bla", "bla");
        Division division2 = new Division("bla", "bla", "bla");
        Division division3 = new Division("checkThis", "bla", "bla");
        List<Division> divisionList = Arrays.asList(division, division2, division3);
        divisionRepository.saveAll(divisionList);
        Optional<Division> toCheck = divisionRepository.findById(3);
        Assertions.assertThat(toCheck.isPresent()).isTrue();
    }*/


}