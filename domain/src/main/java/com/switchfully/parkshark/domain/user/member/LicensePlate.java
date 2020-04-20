package com.switchfully.parkshark.domain.user.member;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class LicensePlate {

    @Column (name = "licensePlateNumber")
    private String licensePlate;

    @Column (name = "countryCode")
    private String countryCode;

    public LicensePlate() {
    }
}
