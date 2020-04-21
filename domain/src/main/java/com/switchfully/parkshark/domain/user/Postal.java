package com.switchfully.parkshark.domain.user;

import javax.persistence.*;

@Embeddable
public class Postal {

    @Column (name = "code")
    private String code;

    @Column (name = "city")
    private String city;

    public Postal() {
    }

    public Postal(String code, String city) {
        this.code = code;
        this.city = city;
    }
}
