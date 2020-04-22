package com.switchfully.parkshark.service.services;

import com.switchfully.parkshark.domain.division.Division;
import com.switchfully.parkshark.domain.exceptions.DivisionDoesNotExistException;
import com.switchfully.parkshark.domain.parkinglot.ParkingLotRepository;
import com.switchfully.parkshark.service.mappers.ParkingLotMapper;
import com.switchfully.parkshark.service.parkinglot.CreateParkingLotDto;
import com.switchfully.parkshark.service.parkinglot.ParkingLotDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ParkingLotService {

    private final ParkingLotRepository parkingLotRepository;

    @Autowired
    public ParkingLotService(ParkingLotRepository parkingLotRepository) {
        this.parkingLotRepository = parkingLotRepository;
    }

    public ParkingLotDto registerParkingLot(CreateParkingLotDto createParkingLotDto) {
        return ParkingLotMapper.toDto(parkingLotRepository.save(ParkingLotMapper.toParkingLot(createParkingLotDto)));
    }

    //todo: have it return limited parking lots with the id, name, capacity and the contact person's e-mail + telephone (nothing else) ==> use views and flatten contactperson in dto
    public List<ParkingLotDto> getAllParkingLots(){
        return ParkingLotMapper.toDto(parkingLotRepository.findAll());
    }

}
