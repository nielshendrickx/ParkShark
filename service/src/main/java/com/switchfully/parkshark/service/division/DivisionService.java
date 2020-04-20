package com.switchfully.parkshark.service.division;

import com.switchfully.parkshark.domain.division.Division;
import com.switchfully.parkshark.domain.division.DivisionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DivisionService {

    private DivisionRepository divisionRepository;

    @Autowired
    public DivisionService(DivisionRepository divisionRepository) {
        this.divisionRepository = divisionRepository;
    }


    public DivisionDTO saveDivision(CreateDivisionDTO createDivisionDTO) {
        return DivisionMapper.toDto(divisionRepository.save(DivisionMapper.toDivision(createDivisionDTO)));
    }
}
