package com.switchfully.parkshark.service.division;

import com.switchfully.parkshark.domain.division.Division;

public class DivisionMapper {

    public static Division toDivision(CreateDivisionDTO createDivisionDTO){
        return new Division(createDivisionDTO.getName(),
                createDivisionDTO.getOriginalName(),
                createDivisionDTO.getDirector());
    }

    public static DivisionDTO toDto(Division division) {
        return new DivisionDTO(division);
    }
}
