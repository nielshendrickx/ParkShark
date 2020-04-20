package com.switchfully.parkshark.domain.user;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table (name = "postal")
public class Postal {

    @Id
    @Column (name = "id")
    private long id;

    @Column (name = "code")
    private String code;

    @Column (name = "city")
    private String city;

    public Postal() {
    }
}
