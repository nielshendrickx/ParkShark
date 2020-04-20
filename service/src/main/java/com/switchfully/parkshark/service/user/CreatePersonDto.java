package com.switchfully.parkshark.service.user;

import com.switchfully.parkshark.domain.user.Address;

public class CreatePersonDto {
    private String firstName;
    private String lastName;
    private String mobilePhoneNumber;
    private String regularPhoneNumber;
    private String email;
    private Address address;

    public CreatePersonDto(String firstName, String lastName, String mobilePhoneNumber, String regularPhoneNumber, String email, Address address) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.mobilePhoneNumber = mobilePhoneNumber;
        this.regularPhoneNumber = regularPhoneNumber;
        this.email = email;
        this.address = address;
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
