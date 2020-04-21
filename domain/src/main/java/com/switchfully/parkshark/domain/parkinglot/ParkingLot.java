package com.switchfully.parkshark.domain.parkinglot;

import com.switchfully.parkshark.domain.division.Division;
import com.switchfully.parkshark.domain.user.Address;
import com.switchfully.parkshark.domain.user.contactperson.Contactperson;

import javax.persistence.*;

@Entity
@Table(name = "parking_lot")
public class ParkingLot {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "name")
    private String name;

    @Enumerated(EnumType.ORDINAL)
    private Category category;

    @Column(name = "capacity")
    private int capacity;

    @OneToOne
    @JoinColumn(name = "fk_contactperson_id")
    private Contactperson contactperson;

    @Embedded
    private Address address;

    @Column(name = "price")
    private double pricePerHour;

    @OneToOne
    @JoinColumn(name = "fk_division_id")
    private Division division;







}
