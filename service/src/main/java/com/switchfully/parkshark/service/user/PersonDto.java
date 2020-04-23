package com.switchfully.parkshark.service.user;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonView;
import com.switchfully.parkshark.domain.user.Address;
import com.switchfully.parkshark.domain.Views;

public class PersonDto {
    private long id;
    private String firstName;
    private String lastName;
    private String mobilePhoneNumber;
    private String regularPhoneNumber;
    private String email;
    @JsonView(Views.Internal.class)
    private Address address;

    @JsonCreator
    public PersonDto(@JsonProperty("id") long id, @JsonProperty("firstName") String firstName, @JsonProperty("lastName") String lastName, @JsonProperty("mobilePhoneNumber") String mobilePhoneNumber, @JsonProperty("regularPhoneNumber") String regularPhoneNumber, @JsonProperty("email") String email, @JsonProperty("address") Address address) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.mobilePhoneNumber = mobilePhoneNumber;
        this.regularPhoneNumber = regularPhoneNumber;
        this.email = email;
        this.address = address;
    }

    public long getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getMobilePhoneNumber() {
        return mobilePhoneNumber;
    }

    public String getRegularPhoneNumber() {
        return regularPhoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public Address getAddress() {
        return address;
    }
}
