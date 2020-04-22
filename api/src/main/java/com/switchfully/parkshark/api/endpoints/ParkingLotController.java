package com.switchfully.parkshark.api.endpoints;

import com.fasterxml.jackson.annotation.JsonView;
import com.switchfully.parkshark.api.validation.Validation;
import com.switchfully.parkshark.service.Views;
import com.switchfully.parkshark.service.parkinglot.CreateParkingLotDto;
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

    @Autowired
    public ParkingLotController(ParkingLotService parkingLotService) {
        this.parkingLotService = parkingLotService;
    }

    @PreAuthorize("hasAuthority('VIEW_PARKING_LOT')")
    @GetMapping(produces = "application/json")
    @ApiOperation(value = "Get all parking lots", notes = "A list of all the parking lots will be returned", response = ParkingLotDto.class)
    @ResponseStatus(HttpStatus.OK)
    public Collection<ParkingLotDto> getAllParkingLots() {
        loggerParkingLot.info("Returning all parking lots");
        return parkingLotService.getAllParkingLots();
    }

    @PreAuthorize("hasAuthority('CREATE_PARKING_LOT')")
    //todo public or manager?
    @JsonView(Views.Public.class)
    @PostMapping(consumes = "application/json", produces = "application/json")
    @ApiOperation(value = "Register a parking lot", notes = "A manager can register a parking lot", response = ParkingLotDto.class)
    @ResponseStatus(HttpStatus.CREATED)
    public ParkingLotDto register(@RequestBody CreateParkingLotDto newParkingLot) throws IOException {
        Validation.assertThatDivisionExists(newParkingLot.getDivision().getId());
        loggerParkingLot.info("Creating a new parking lot");
        return parkingLotService.registerParkingLot(newParkingLot);
    }
}