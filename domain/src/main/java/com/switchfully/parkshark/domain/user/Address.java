package com.switchfully.parkshark.domain.user;

import javax.persistence.*;


@Entity
@Table (name = "address")
public class Address {

    @Id
    @Column (name = "id")
    private long id;

    @Column (name = "street")
    private String street;

    @Column (name = "number")
    private String number;

    @OneToOne
    @JoinColumn (name = "postalId")
    private Postal postal;

    public Address() {
    }
}
