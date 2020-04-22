package com.switchfully.parkshark.service.parkinglot;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.switchfully.parkshark.domain.division.Division;
import com.switchfully.parkshark.domain.parkinglot.Category;
import com.switchfully.parkshark.domain.user.Address;
import com.switchfully.parkshark.domain.user.contactperson.Contactperson;

public class CreateParkingLotDto {
    private String name;
    private Category category;
    private int capacity;
    private Contactperson contactperson;
    private Address address;
    private double pricePerHour;
    private Division division;

    @JsonCreator
    public CreateParkingLotDto(String name, Category category, int capacity, Contactperson contactperson, Address address, double pricePerHour, Division division) {
        this.name = name;
        this.category = category;
        this.capacity = capacity;
        this.contactperson = contactperson;
        this.address = address;
        this.pricePerHour = pricePerHour;
        this.division = division;
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
