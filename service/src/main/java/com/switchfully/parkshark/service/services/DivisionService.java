package com.switchfully.parkshark.service.services;

import com.switchfully.parkshark.domain.division.Division;
import com.switchfully.parkshark.domain.division.DivisionRepository;
import com.switchfully.parkshark.domain.exceptions.DivisionDoesNotExistException;
import com.switchfully.parkshark.service.division.CreateDivisionDTO;
import com.switchfully.parkshark.service.division.DivisionDTO;
import com.switchfully.parkshark.service.mappers.DivisionMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class DivisionService {

    private final DivisionRepository divisionRepository;

    @Autowired
    public DivisionService(DivisionRepository divisionRepository) {
        this.divisionRepository = divisionRepository;
    }


    public DivisionDTO saveDivision(CreateDivisionDTO createDivisionDTO) {
        return DivisionMapper.toDto(divisionRepository.save(DivisionMapper.toDivision(createDivisionDTO)));
    }


    public List<DivisionDTO> getAllDivisions() {
        return DivisionMapper.toDtoList(divisionRepository.findAll());
    }


    public void createSubDivision(int divisionId, int subId) {
        assertThatDivisionExists(divisionId);
        assertThatDivisionExists(subId);
        Division parentDivision = divisionRepository.findById(divisionId).get();
        Division subDivision = divisionRepository.findById(subId).get();
        subDivision.setParentDivision(parentDivision);
    }

    private void assertThatDivisionExists(int divisionId) {
        if(!divisionRepository.findById(divisionId).isPresent()){
            throw new DivisionDoesNotExistException(Integer.toString(divisionId));
        }
    }
}
