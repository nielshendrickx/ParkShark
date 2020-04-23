package com.switchfully.parkshark.service.parkinglot;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.switchfully.parkshark.domain.parkinglot.Category;
import com.switchfully.parkshark.domain.user.Address;

public class CreateParkingLotDto {
    private String name;
    private Category category;
    private int capacity;
    private long contactpersonId;
    private Address address;
    private double pricePerHour;
    private long divisionsId;

    @JsonCreator
    public CreateParkingLotDto(@JsonProperty("name") String name, @JsonProperty("category") Category category, @JsonProperty("capacity") int capacity, @JsonProperty("contactpersonId") long contactpersonId, @JsonProperty("address") Address address, @JsonProperty("pricePerHour") double pricePerHour, @JsonProperty("divisionsId") long divisionsId) {
        this.name = name;
        this.category = category;
        this.capacity = capacity;
        this.contactpersonId = contactpersonId;
        this.address = address;
        this.pricePerHour = pricePerHour;
        this.divisionsId = divisionsId;
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

    public long getContactpersonId() {
        return contactpersonId;
    }

    public Address getAddress() {
        return address;
    }

    public double getPricePerHour() {
        return pricePerHour;
    }

    public long getDivisionsId() {
        return divisionsId;
    }
}
