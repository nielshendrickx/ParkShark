package com.switchfully.parkshark;


import com.switchfully.parkshark.domain.division.Division;
import com.switchfully.parkshark.domain.division.DivisionRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;


@DataJpaTest
class DivisionRepositoryTest {

    @Autowired
    private DivisionRepository divisionRepository;

    @Test
    void saveDivision(){
        Division division = new Division("bla","bla","bla");
        Division actualValue = divisionRepository.save(division);
        Assertions.assertThat(actualValue).isEqualTo(division);
    }
}