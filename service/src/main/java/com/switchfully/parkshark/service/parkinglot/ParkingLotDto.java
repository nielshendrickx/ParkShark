package com.switchfully.parkshark.service.parkinglot;

import com.fasterxml.jackson.annotation.JsonView;
import com.switchfully.parkshark.domain.division.Division;
import com.switchfully.parkshark.domain.parkinglot.Category;
import com.switchfully.parkshark.domain.parkinglot.ParkingLot;
import com.switchfully.parkshark.domain.user.Address;
import com.switchfully.parkshark.domain.user.contactperson.Contactperson;
import com.switchfully.parkshark.service.Views;

public class ParkingLotDto {
    @JsonView({Views.Manager.class, Views.showAllParkingInfo.class})
    private String name;
    @JsonView(Views.showAllParkingInfo.class)
    private Category category;
    @JsonView({Views.Manager.class, Views.showAllParkingInfo.class})
    private int capacity;
    @JsonView({Views.Manager.class, Views.showAllParkingInfo.class})
    private Contactperson contactperson;
    @JsonView(Views.showAllParkingInfo.class)
    private Address address;
    @JsonView( Views.showAllParkingInfo.class)
    private double pricePerHour;
    @JsonView(Views.showAllParkingInfo.class)
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
