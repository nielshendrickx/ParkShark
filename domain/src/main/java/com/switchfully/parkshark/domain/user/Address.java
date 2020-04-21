package com.switchfully.parkshark.domain.user;

import javax.persistence.*;


@Embeddable
public class Address {

    @Column (name = "street")
    private String street;

    @Column (name = "number")
    private String number;

    @Embedded
    private Postal postal;

    public Address() {
    }
}
