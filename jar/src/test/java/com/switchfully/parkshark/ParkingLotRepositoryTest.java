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
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
public class ParkingLotRepositoryTest {
    private ParkingLotRepository parkingLotRepository;
    private ContactpersonRepository contactpersonRepository;
    private DivisionRepository divisionRepository;

    @Autowired
    public ParkingLotRepositoryTest(ParkingLotRepository parkingLotRepository, ContactpersonRepository contactpersonRepository, DivisionRepository divisionRepository) {
        this.parkingLotRepository = parkingLotRepository;
        this.contactpersonRepository = contactpersonRepository;
        this.divisionRepository = divisionRepository;
        Postal postal = new Postal("1000", "Brussel");
        Address address = new Address("Wetstraat", "1", postal);
        Contactperson contactperson = new Contactperson("firstName", "lastName", "contact@parkshark.com", "0473000000", "01680000", address);
        contactpersonRepository.save(contactperson);
        Division division = new Division("DivisionName", "Division original name", "Director");
        divisionRepository.save(division);
    }

    @Test
    void saveThreeParkingLots() {
        Postal postal = new Postal("1000", "Brussel");
        Address address = new Address("Wetstraat", "1", postal);
        ParkingLot parkingLot = new ParkingLot("parkingLotName", Category.ABOVEGROUND, 100, contactpersonRepository.findByEmail("contact@parkshark.com"), address, 12.1, divisionRepository.findAll().get(0));
        ParkingLot parkingLot2 = new ParkingLot("parkingLotName2", Category.ABOVEGROUND, 100, contactpersonRepository.findByEmail("contact@parkshark.com"), address, 12.1, divisionRepository.findAll().get(0));
        ParkingLot parkingLot3 = new ParkingLot("parkingLotName3", Category.ABOVEGROUND, 100, contactpersonRepository.findByEmail("contact@parkshark.com"), address, 12.1, divisionRepository.findAll().get(0));
        parkingLotRepository.save(parkingLot);
        parkingLotRepository.save(parkingLot2);
        parkingLotRepository.save(parkingLot3);
        Assertions.assertThat(parkingLotRepository.count()).isEqualTo(3);
    }
}