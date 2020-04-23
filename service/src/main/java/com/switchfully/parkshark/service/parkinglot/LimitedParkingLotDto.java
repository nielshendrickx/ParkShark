package com.switchfully.parkshark.service.parkinglot;

import com.switchfully.parkshark.domain.parkinglot.ParkingLot;

public class LimitedParkingLotDto {
    private int id;
    private String name;
    private int capacity;

    private String contactpersonEmail;
    private String contactpersonTelephoneRegular;
    private String contactpersonTelephoneMobile;

    public LimitedParkingLotDto(ParkingLot parkingLot) {
        this.id = parkingLot.getId();
        this.name = parkingLot.getName();
        this.capacity=parkingLot.getCapacity();
        this.contactpersonEmail = parkingLot.getContactperson().getEmail();
        this.contactpersonTelephoneRegular = parkingLot.getContactperson().getRegularPhoneNumber();
        this.contactpersonTelephoneMobile = parkingLot.getContactperson().getMobilePhoneNumber();
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getCapacity() {
        return capacity;
    }

    public String getContactpersonEmail() {
        return contactpersonEmail;
    }

    public String getContactpersonTelephoneRegular() {
        return contactpersonTelephoneRegular;
    }

    public String getContactpersonTelephoneMobile() {
        return contactpersonTelephoneMobile;
    }
}