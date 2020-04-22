package com.switchfully.parkshark.domain.parkinglot;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ParkingLotRepository extends CrudRepository<ParkingLot, Long> {
    List<ParkingLot> findAll();
}
