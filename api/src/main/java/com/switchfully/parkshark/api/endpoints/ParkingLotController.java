package com.switchfully.parkshark.api.endpoints;

import com.switchfully.parkshark.service.parkinglot.CreateParkingLotDto;
import com.switchfully.parkshark.service.parkinglot.LimitedParkingLotDto;
import com.switchfully.parkshark.service.parkinglot.ParkingLotDto;
import com.switchfully.parkshark.service.services.ParkingLotService;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.Collection;

@RestController
@RequestMapping(path = ParkingLotController.PARKING_LOT_RESOURCE_PATH)
public class ParkingLotController {
    public static final String PARKING_LOT_RESOURCE_PATH = "/parkinglot";
    private final Logger loggerParkingLot = LoggerFactory.getLogger(ParkingLotController.class);
    private ParkingLotService parkingLotService;
    private Validation validation;

    @Autowired
    public ParkingLotController(ParkingLotService parkingLotService, Validation validation) {
        this.parkingLotService = parkingLotService;
        this.validation = validation;
    }

    @PreAuthorize("hasAuthority('VIEW_PARKING_LOT')")
    @GetMapping(produces = "application/json")
    @ApiOperation(value = "Get all parking lots", notes = "A list of all the parking lots will be returned", response = ParkingLotDto.class)
    @ResponseStatus(HttpStatus.OK)
    public Collection<LimitedParkingLotDto> getAllParkingLots() {
        loggerParkingLot.info("Returning all parking lots");
        return parkingLotService.getAllParkingLotsWithLimitedInfo();
    }

    @PreAuthorize("hasAuthority('CREATE_PARKING_LOT')")
    @PostMapping(consumes = "application/json", produces = "application/json")
    @ApiOperation(value = "Register a parking lot", notes = "A manager can register a parking lot", response = ParkingLotDto.class)
    @ResponseStatus(HttpStatus.CREATED)
    public ParkingLotDto register(@RequestBody CreateParkingLotDto newParkingLot) throws IOException {
        validation.assertThatDivisionExists(newParkingLot.getDivisionsId());
        loggerParkingLot.info("Creating a new parking lot");
        return parkingLotService.registerParkingLot(newParkingLot);
    }
}