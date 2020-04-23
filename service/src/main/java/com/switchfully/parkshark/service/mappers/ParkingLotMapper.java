package com.switchfully.parkshark.service.mappers;

import com.google.common.collect.Lists;
import com.switchfully.parkshark.domain.division.DivisionRepository;
import com.switchfully.parkshark.domain.parkinglot.ParkingLot;
import com.switchfully.parkshark.domain.user.contactperson.ContactpersonRepository;
import com.switchfully.parkshark.service.parkinglot.CreateParkingLotDto;
import com.switchfully.parkshark.service.parkinglot.ParkingLotDto;
import com.switchfully.parkshark.service.services.ContactPersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Component
public class ParkingLotMapper {


    private static ContactpersonRepository contactpersonRepository;
    private static DivisionRepository divisionRepository;

    @Autowired
    public ParkingLotMapper(ContactpersonRepository contactpersonRepository, DivisionRepository divisionRepository) {
        this.contactpersonRepository = contactpersonRepository;
        this.divisionRepository = divisionRepository;
    }

    public static ParkingLot toParkingLot(CreateParkingLotDto createParkingLotDto) {
        return new ParkingLot(
                createParkingLotDto.getName(),
                createParkingLotDto.getCategory(),
                createParkingLotDto.getCapacity(),
                contactpersonRepository.findById(createParkingLotDto.getContactpersonsId()),
                createParkingLotDto.getAddress(),
                createParkingLotDto.getPricePerHour(),
                divisionRepository.findById(createParkingLotDto.getDivisionsID()));
    }

    public static ParkingLotDto toDto (ParkingLot parkingLot) {
        return new ParkingLotDto(parkingLot);
    }

    public static List<ParkingLotDto> toDto(Iterable<ParkingLot> parkingLots){
        List<ParkingLot> list = Lists.newArrayList(parkingLots);
        return list.stream().map(ParkingLotMapper::toDto).collect(Collectors.toList());
    }

}
