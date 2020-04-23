package com.switchfully.parkshark.service.parkinglot;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.switchfully.parkshark.domain.division.Division;
import com.switchfully.parkshark.domain.parkinglot.Category;
import com.switchfully.parkshark.domain.user.Address;

public class CreateParkingLotDto {
    private String name;
    private Category category;
    private int capacity;
    private int contactpersonsId;
    private Address address;
    private double pricePerHour;
    private int divisionsID;

    @JsonCreator
    public CreateParkingLotDto(String name, Category category, int capacity, int contactpersonsId, Address address, double pricePerHour, int divisionsID) {
        this.name = name;
        this.category = category;
        this.capacity = capacity;
        this.contactpersonsId = contactpersonsId;
        this.address = address;
        this.pricePerHour = pricePerHour;
        this.divisionsID = divisionsID;
    }

    public CreateParkingLotDto() {
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

    public int getContactpersonsId() {
        return contactpersonsId;
    }

    public Address getAddress() {
        return address;
    }

    public double getPricePerHour() {
        return pricePerHour;
    }

    public int getDivisionsID() {
        return divisionsID;
    }
}
