package com.switchfully.parkshark.domain.user;

import javax.persistence.*;


@Embeddable
public class Address {

    @Column (name = "streetName")
    private String streetName;

    @Column (name = "streetNumber")
    private String streetNumber;

    @Embedded
    private Postal postal;

    public Address() {
    }

    public Address(String streetName, String streetNumber, Postal postal) {
        this.streetName = streetName;
        this.streetNumber = streetNumber;
        this.postal = postal;
    }
}
