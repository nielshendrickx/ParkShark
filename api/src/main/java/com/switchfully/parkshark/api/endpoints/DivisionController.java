package com.switchfully.parkshark.api.endpoints;

import com.switchfully.parkshark.service.division.CreateDivisionDTO;
import com.switchfully.parkshark.service.division.DivisionDTO;
import com.switchfully.parkshark.service.services.DivisionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(path = "/divisions")
public class DivisionController {

    private DivisionService divisionService;

    @Autowired
    public DivisionController(DivisionService divisionService) {
        this.divisionService = divisionService;
    }

    @PostMapping(consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public DivisionDTO createDivision(@Valid @RequestBody CreateDivisionDTO createDivisionDTO){
        return divisionService.saveDivision(createDivisionDTO);
    }

    @GetMapping(produces = APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public List<DivisionDTO> getAllDivisions(){
        return divisionService.getAllDivisions();
    }

//    @PostMapping(path = "/{id}")
//    @ResponseStatus(HttpStatus.CREATED)
//    public void createSubDivision(@PathVariable int id, ){
//        divisionService.createSubDivision();
//    }

}