package com.switchfully.parkshark.api.endpoints;

import com.switchfully.parkshark.service.division.CreateDivisionDTO;
import com.switchfully.parkshark.service.division.DivisionDTO;
import com.switchfully.parkshark.service.services.DivisionService;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(path = DivisionController.DIVISION_RESOURCE_PATH)
public class DivisionController {

    public static final String DIVISION_RESOURCE_PATH = "/divisions";
    private final Logger loggerDivision = LoggerFactory.getLogger(DivisionController.class);
    private final DivisionService divisionService;

    @Autowired
    public DivisionController(DivisionService divisionService) {
        this.divisionService = divisionService;
    }

    @PreAuthorize("hasAuthority('CREATE_DIVISION')")
    @PostMapping(consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Create a division", notes = "A manager can create a division", response = DivisionDTO.class)
    @ResponseStatus(HttpStatus.CREATED)
    public DivisionDTO createDivision(@Valid @RequestBody CreateDivisionDTO createDivisionDTO) {
        loggerDivision.info("Creating a new division");
        return divisionService.saveDivision(createDivisionDTO);
    }

    @PreAuthorize("hasAuthority('VIEW_DIVISIONS')")
    @GetMapping(produces = APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Get all divisions", notes = "A list of all the registered division will be returned", response = DivisionDTO.class)
    @ResponseStatus(HttpStatus.OK)
    public List<DivisionDTO> getAllDivisions() {
        loggerDivision.info("Returning all divisions");
        return divisionService.getAllDivisions();
    }

    @PreAuthorize("hasAuthority('CREATE_SUB_DIVISION')")
    @PostMapping(path = "/{primaryKeyId}/{parentDivisionKey}")
    @ApiOperation(value = "Assign a subdivision to a division", notes = "A division is a subdivision when it refers to a other division")
    @ResponseStatus(HttpStatus.CREATED)
    public void assignSubDivision(@PathVariable int primaryKeyId, @PathVariable int parentDivisionKey) {
        loggerDivision.info("Assign subdivision");
        divisionService.assignSubDivision(parentDivisionKey,primaryKeyId);
    }

}
