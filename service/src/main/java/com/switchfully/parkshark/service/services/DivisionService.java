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
        return DivisionMapper.toDto(divisionRepository.findAll());
    }


    public void assignSubDivision(long divisionId, long subId) {
        assertThatDivisionExists(divisionId);
        assertThatDivisionExists(subId);
        Division parentDivision = divisionRepository.findById(divisionId);
        Division subDivision = divisionRepository.findById(subId);
        subDivision.setParentDivision(parentDivision);
    }

    public void assertThatDivisionExists(long divisionId) {
        if(divisionRepository.findById(divisionId) == null){
            throw new DivisionDoesNotExistException(Long.toString(divisionId));
        }
    }
}
