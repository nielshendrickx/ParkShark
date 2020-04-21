package com.switchfully.parkshark.domain.user.member;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class LicensePlate {

    @Column (name = "licensePlateNumber")
    private String licensePlateNumber;

    @Column (name = "countryCode")
    private String countryCode;

    public LicensePlate() {
    }

    public LicensePlate(String licensePlateNumber, String countryCode) {
        this.licensePlateNumber = licensePlateNumber;
        this.countryCode = countryCode;
    }
}
