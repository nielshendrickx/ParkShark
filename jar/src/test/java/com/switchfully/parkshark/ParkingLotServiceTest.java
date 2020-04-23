package com.switchfully.parkshark;

import com.switchfully.parkshark.domain.division.Division;
import com.switchfully.parkshark.domain.parkinglot.Category;
import com.switchfully.parkshark.domain.parkinglot.ParkingLot;
import com.switchfully.parkshark.domain.parkinglot.ParkingLotRepository;
import com.switchfully.parkshark.domain.user.Address;
import com.switchfully.parkshark.domain.user.Postal;
import com.switchfully.parkshark.domain.user.contactperson.Contactperson;
import com.switchfully.parkshark.domain.user.contactperson.ContactpersonRepository;
import com.switchfully.parkshark.service.parkinglot.CreateParkingLotDto;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

//todo
@SpringBootTest
public class ParkingLotServiceTest {

    @Autowired
    private ParkingLotRepository parkingLotRepository;

    @Autowired
    private ContactpersonRepository contactpersonRepository;

  /*  @Test
    void whenCreateParkingLotDtoIsSaved_checkReturnDto() {
        Postal postal = new Postal("1000", "Brussel");
        Address address = new Address("Wetstraat", "1", postal);
        Contactperson contactperson = new Contactperson("a", "b", "123", "456", "test@test.com", address);
        contactpersonRepository.save(contactperson);
        CreateParkingLotDto createParkingLotDto = new CreateParkingLotDto("name",Category.ABOVEGROUND, 100, contactperson, address, 12.1, new Division());

    }*/
}