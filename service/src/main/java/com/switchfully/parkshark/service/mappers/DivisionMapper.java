package com.switchfully.parkshark.service.mappers;

import com.google.common.collect.Lists;
import com.switchfully.parkshark.domain.division.Division;
import com.switchfully.parkshark.service.division.CreateDivisionDTO;
import com.switchfully.parkshark.service.division.DivisionDTO;

import java.util.List;
import java.util.stream.Collectors;

public class DivisionMapper {

    public static Division toDivision(CreateDivisionDTO createDivisionDTO){
        return new Division(createDivisionDTO.getName(),
                createDivisionDTO.getOriginalName(),
                createDivisionDTO.getDirector());
    }

    public static DivisionDTO toDto(Division division) {
        return new DivisionDTO(division);
    }

    public static List<DivisionDTO> toDtoList(Iterable<Division> divisions){
        List<Division> list = Lists.newArrayList(divisions);
        return list.stream().map(DivisionMapper::toDto).collect(Collectors.toList());
    }
}
