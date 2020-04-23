package com.switchfully.parkshark;

import com.switchfully.parkshark.domain.division.Division;
import com.switchfully.parkshark.domain.parkinglot.Category;
import com.switchfully.parkshark.domain.parkinglot.ParkingLotRepository;
import com.switchfully.parkshark.domain.user.Address;
import com.switchfully.parkshark.domain.user.Postal;
import com.switchfully.parkshark.domain.user.contactperson.Contactperson;
import com.switchfully.parkshark.domain.user.contactperson.ContactpersonRepository;
import com.switchfully.parkshark.service.parkinglot.CreateParkingLotDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

//todo: fix test with correct contact person info (once contactPerson is done)
@SpringBootTest
public class ParkingLotServiceTest {

    @Autowired
    private ParkingLotRepository parkingLotRepository;

    @Autowired
    private ContactpersonRepository contactpersonRepository;

//    @Test
//    void whenCreateParkingLotDtoIsSaved_checkReturnDto() {
//        Postal postal = new Postal("1000", "Brussel");
//        Address address = new Address("Wetstraat", "1", postal);
//        Contactperson contactperson = new Contactperson("firstName", "lastName", "contact@parkshark.com", "0473000000", "01680000", address);
//        contactpersonRepository.save(contactperson);
//        CreateParkingLotDto createParkingLotDto = new CreateParkingLotDto("name", Category.ABOVEGROUND, 100, contactperson.getId(), address, 12.1, new Division());
//    }

    @Test
    void getAllParkingLotsReturnsLimitedInfo() {
    }

    @Test
    void createParkingLot() {
    }

    @Test
    void name() {
    }
}