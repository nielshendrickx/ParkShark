package com.switchfully.parkshark.service.services;

import com.switchfully.parkshark.domain.division.Division;
import com.switchfully.parkshark.domain.division.DivisionRepository;
import com.switchfully.parkshark.domain.exceptions.DivisionDoesNotExistException;
import com.switchfully.parkshark.service.division.CreateDivisionDTO;
import com.switchfully.parkshark.service.division.DivisionDTO;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class DivisionServiceTest {

    @Mock
    DivisionRepository divisionRepository;

    @InjectMocks
    DivisionService divisionService;

    @Test
    void saveDivision() {
        // Given
        when(divisionRepository.save(new Division())).thenReturn(new Division());
        // When
        DivisionDTO divisionDTO = divisionService.saveDivision(new CreateDivisionDTO());
        // Then
        assertThat(divisionDTO).isNotNull();
        assertThat(divisionDTO.getId()).isNotNull();
        assertThat(divisionDTO).isInstanceOf(DivisionDTO.class);
    }

    @Test
    void getAllDivision() {
        // Given
        Iterable<Division> divisions = new ArrayList<>(List.of(new Division(), new Division()));
        when(divisionRepository.findAll()).thenReturn(divisions);
        // When
        List<DivisionDTO> divisionDTOS = divisionService.getAllDivisions();
        // Then
        assertThat(divisionDTOS).hasSize(2);
    }

    @Test
    void assignSubDivision_givenWrongSubDivisionId_thenThrowDivisionDoesNotExistException() {
        // Given
        when(divisionRepository.findById(1)).thenReturn(new Division());
        // When
        // Then
        assertThatThrownBy(() -> divisionService.assignSubDivision(1, 2)).isInstanceOf(DivisionDoesNotExistException.class);
    }

    @Test
    void assignSubDivision_givenWrongDivisionId_thenThrowDivisionDoesNotExistException() {
        // Given
        when(divisionRepository.findById(1)).thenReturn(null);
        // When
        // Then
        assertThatThrownBy(() -> divisionService.assignSubDivision(1, 2)).isInstanceOf(DivisionDoesNotExistException.class);
    }
}
