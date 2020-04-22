package com.switchfully.parkshark.service.mappers;

import com.google.common.collect.Lists;
import com.switchfully.parkshark.domain.division.Division;
import com.switchfully.parkshark.domain.parkinglot.ParkingLot;
import com.switchfully.parkshark.service.division.DivisionDTO;
import com.switchfully.parkshark.service.parkinglot.CreateParkingLotDto;
import com.switchfully.parkshark.service.parkinglot.ParkingLotDto;

import java.util.List;
import java.util.stream.Collectors;

public class ParkingLotMapper {
    public static ParkingLot toParkingLot(CreateParkingLotDto createParkingLotDto) {
        return new ParkingLot(
                createParkingLotDto.getName(),
                createParkingLotDto.getCategory(),
                createParkingLotDto.getCapacity(),
                createParkingLotDto.getContactperson(),
                createParkingLotDto.getAddress(),
                createParkingLotDto.getPricePerHour(),
                createParkingLotDto.getDivision());
    }

    public static ParkingLotDto toDto (ParkingLot parkingLot) {
        return new ParkingLotDto(parkingLot);
    }

    public static List<ParkingLotDto> toDto(Iterable<ParkingLot> parkingLots){
        List<ParkingLot> list = Lists.newArrayList(parkingLots);
        return list.stream().map(ParkingLotMapper::toDto).collect(Collectors.toList());
    }

}
