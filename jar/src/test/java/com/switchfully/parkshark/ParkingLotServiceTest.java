package com.switchfully.parkshark;

import com.switchfully.parkshark.domain.division.Division;
import com.switchfully.parkshark.domain.division.DivisionRepository;
import com.switchfully.parkshark.domain.parkinglot.Category;
import com.switchfully.parkshark.domain.parkinglot.ParkingLot;
import com.switchfully.parkshark.domain.parkinglot.ParkingLotRepository;
import com.switchfully.parkshark.domain.user.Address;
import com.switchfully.parkshark.domain.user.Postal;
import com.switchfully.parkshark.domain.user.contactperson.Contactperson;
import com.switchfully.parkshark.domain.user.contactperson.ContactpersonRepository;
import com.switchfully.parkshark.service.parkinglot.CreateParkingLotDto;
import com.switchfully.parkshark.service.parkinglot.ParkingLotDto;
import com.switchfully.parkshark.service.services.ParkingLotService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

//todo
@SpringBootTest
public class ParkingLotServiceTest {
    private ParkingLotService parkingLotService;
    private ContactpersonRepository contactpersonRepository;
    private DivisionRepository divisionRepository;
    private ParkingLotRepository parkingLotRepository;

    @Autowired
    public ParkingLotServiceTest(ParkingLotService parkingLotService, ContactpersonRepository contactpersonRepository, DivisionRepository divisionRepository, ParkingLotRepository parkingLotRepository) {
        this.parkingLotService = parkingLotService;
        this.contactpersonRepository = contactpersonRepository;
        this.divisionRepository = divisionRepository;
        this.parkingLotRepository = parkingLotRepository;
    }

    @Test
    void whenCreateParkingLotDtoIsSaved_checkReturnDto() {
        Postal postal = new Postal("1000", "Brussel");
        Address address = new Address("Wetstraat", "1", postal);
        Contactperson contactperson = new Contactperson("a", "b", "contact@parkshark.com", "456", "0000", address);
        contactpersonRepository.save(contactperson);
        Division division = new Division("bla", "bla", "bla");
        divisionRepository.save(division);
        CreateParkingLotDto createParkingLotDto = new CreateParkingLotDto("Test parking lot", Category.UNDERGROUND, 111, contactpersonRepository.findByEmail("contact@parkshark.com").getId(), address, 5.5, division.getId());
        ParkingLotDto parkingLot = parkingLotService.registerParkingLot(createParkingLotDto);
        Assertions.assertThat(parkingLot.getCapacity()).isEqualTo(111);
    }

    @AfterEach
    void breakDown() {
        parkingLotRepository.deleteAll();
        contactpersonRepository.deleteAll();
        divisionRepository.deleteAll();
    }
}