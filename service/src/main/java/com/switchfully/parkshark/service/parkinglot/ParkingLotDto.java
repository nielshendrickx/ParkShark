package com.switchfully.parkshark.service.parkinglot;

import com.switchfully.parkshark.domain.division.Division;
import com.switchfully.parkshark.domain.parkinglot.Category;
import com.switchfully.parkshark.domain.parkinglot.ParkingLot;
import com.switchfully.parkshark.domain.user.Address;
import com.switchfully.parkshark.domain.user.contactperson.Contactperson;

public class ParkingLotDto {
    private String name;
    private Category category;
    private int capacity;
    private Contactperson contactperson;
    private Address address;
    private double pricePerHour;
    private Division division;

    public ParkingLotDto(ParkingLot parkingLot) {
        this.name = parkingLot.getName();
        this.category=parkingLot.getCategory();
        this.capacity=parkingLot.getCapacity();
        this.contactperson = parkingLot.getContactperson();
        this.address=parkingLot.getAddress();
        this.pricePerHour = parkingLot.getPricePerHour();
        this.division = parkingLot.getDivision();
    }

    public String getName() {
        return name;
    }

    public Category getCategory() {
        return category;
    }

    public int getCapacity() {
        return capacity;
    }

    public Contactperson getContactperson() {
        return contactperson;
    }

    public Address getAddress() {
        return address;
    }

    public double getPricePerHour() {
        return pricePerHour;
    }

    public Division getDivision() {
        return division;
    }
}
