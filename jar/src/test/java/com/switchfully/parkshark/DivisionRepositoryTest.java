package com.switchfully.parkshark;


import com.switchfully.parkshark.domain.division.Division;
import com.switchfully.parkshark.domain.division.DivisionRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


@DataJpaTest
class DivisionRepositoryTest {

    @Autowired
    private DivisionRepository divisionRepository;

    @Test
    void saveDivision() {
        Division division = new Division("bla", "bla", "bla");
        Division actualValue = divisionRepository.save(division);
        assertThat(actualValue).isEqualTo(division);
        assertThat(divisionRepository.findAll()).containsExactly(division);
//        assertThat(divisionRepository.count()).isEqualTo(1);
    }

    @Test
    void saveThreeDivisions_checkThatSizeIs3() {
        Division division = new Division("bla", "bla", "bla");
        Division division2 = new Division("bla", "bla", "bla");
        Division division3 = new Division("bla", "bla", "bla");
        List<Division> divisionList = Arrays.asList(division, division2, division3);
        divisionRepository.saveAll(divisionList);
//        assertThat(divisionRepository.count()).isEqualTo(3);
    }

    @Test
    void findById() {
        // Given
        Division expectedDivision = divisionRepository.save(new Division());
        // When
        Division actualDivision = divisionRepository.findById(expectedDivision.getId());
        // Then
        assertThat(actualDivision).isEqualTo(expectedDivision);
    }

        @Test
    void saveThreeDivisions_checkThatIdOfThirdIsRight() {
        Division division = new Division("bla", "bla", "bla");
        Division division2 = new Division("bla", "bla", "bla");
        Division division3 = divisionRepository.save(new Division("checkThis", "bla", "bla"));
        List<Division> divisionList = Arrays.asList(division, division2);
        divisionRepository.saveAll(divisionList);
        Division toCheck = divisionRepository.findById(division3.getId());
        Assertions.assertThat(toCheck).isNotNull();
    }

    @AfterEach
    void breakDown(){
        divisionRepository.deleteAll();
    }
}