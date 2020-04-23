package com.switchfully.parkshark.domain.user.member;

import com.fasterxml.jackson.annotation.JsonView;
import com.switchfully.parkshark.domain.Views;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class LicensePlate {

    @Column (name = "licensePlateNumber")
    private String licensePlateNumber;

    @Column (name = "countryCode")
    @JsonView(Views.Internal.class)
    private String countryCode;

    public LicensePlate() {
    }

    public LicensePlate(String licensePlateNumber, String countryCode) {
        this.licensePlateNumber = licensePlateNumber;
        this.countryCode = countryCode;
    }
}
