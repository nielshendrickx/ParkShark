package com.switchfully.parkshark.service.services;

import com.switchfully.parkshark.domain.parkinglot.ParkingLotRepository;
import com.switchfully.parkshark.service.mappers.ParkingLotMapper;
import com.switchfully.parkshark.service.parkinglot.CreateParkingLotDto;
import com.switchfully.parkshark.service.parkinglot.LimitedParkingLotDto;
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

    public List<LimitedParkingLotDto> getAllParkingLotsWithLimitedInfo() {
        return ParkingLotMapper.toLimitedDto(parkingLotRepository.findAll());
    }
}