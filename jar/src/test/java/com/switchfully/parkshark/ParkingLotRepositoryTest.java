package com.switchfully.parkshark;

import com.switchfully.parkshark.domain.division.Division;
import com.switchfully.parkshark.domain.parkinglot.Category;
import com.switchfully.parkshark.domain.parkinglot.ParkingLot;
import com.switchfully.parkshark.domain.parkinglot.ParkingLotRepository;
import com.switchfully.parkshark.domain.user.Address;
import com.switchfully.parkshark.domain.user.Postal;
import com.switchfully.parkshark.domain.user.contactperson.Contactperson;
import com.switchfully.parkshark.domain.user.contactperson.ContactpersonRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
public class ParkingLotRepositoryTest {
    @Autowired
    private ParkingLotRepository parkingLotRepository;

    @Autowired
    private ContactpersonRepository contactpersonRepository;

    @Test
    void saveParkingLot() {
        Postal postal = new Postal("1000", "Brussel");
        Address address = new Address("Wetstraat", "1", postal);
        Contactperson contactperson = new Contactperson("a", "b", "123", "456", "test@test.com", address);
        contactpersonRepository.save(contactperson);
        ParkingLot parkingLot = new ParkingLot("parkingLotName", Category.ABOVEGROUND, 100, contactperson, address, 12.1, new Division());
        ParkingLot actualValue = parkingLotRepository.save(parkingLot);
        Assertions.assertThat(actualValue).isEqualTo(parkingLot);
        //todo: fix line below and make it work, using the contactperson id that will be made
        //Assertions.assertThat(parkingLotRepository.count()).isEqualTo(1);
    }

    @Test
    void saveThreeParkingLots() {
        Postal postal = new Postal("1000", "Brussel");
        Address address = new Address("Wetstraat", "1", postal);
        Contactperson contactperson = new Contactperson("a", "b", "123", "456", "test@test.com", address);
        contactpersonRepository.save(contactperson);
        ParkingLot parkingLot = new ParkingLot("parkingLotName", Category.ABOVEGROUND, 100, contactperson, address, 12.1, new Division());
        ParkingLot parkingLot2 = new ParkingLot("parkingLotName2", Category.ABOVEGROUND, 100, contactperson, address, 12.1, new Division());
        ParkingLot parkingLot3 = new ParkingLot("parkingLotName3", Category.ABOVEGROUND, 100, contactperson, address, 12.1, new Division());
        parkingLotRepository.save(parkingLot);
        parkingLotRepository.save(parkingLot2);
        parkingLotRepository.save(parkingLot3);
        //todo: fix line below and make it work
        //Assertions.assertThat(parkingLotRepository.count()).isEqualTo(3);
    }

    @AfterEach
    void deleteContactPersons () {
        contactpersonRepository.deleteAll();
        parkingLotRepository.deleteAll();
    }
}
