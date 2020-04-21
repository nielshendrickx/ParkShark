package com.switchfully.parkshark.service.user;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.switchfully.parkshark.domain.user.Address;
import com.switchfully.parkshark.domain.user.member.LicensePlate;
import com.switchfully.parkshark.domain.user.member.MembershipLevel;

import java.time.LocalDate;

public class CreateMemberDto extends CreatePersonDto {
    private LicensePlate licensePlate;
    private MembershipLevel membershipLevel;
    private String password;

    @JsonCreator
    public CreateMemberDto(@JsonProperty("firstName") String firstName, @JsonProperty("lastName") String lastName, @JsonProperty("mobilePhoneNumber") String mobilePhoneNumber, @JsonProperty("regularPhoneNumber") String regularPhoneNumber, @JsonProperty("email") String email, @JsonProperty("address") Address address, @JsonProperty("licensePlate") LicensePlate licensePlate, @JsonProperty("password") String password) {
        super(firstName, lastName, mobilePhoneNumber, regularPhoneNumber, email, address);
        this.licensePlate = licensePlate;
        this.membershipLevel = new MembershipLevel(); // TODO
        this.password = password;
    }

    public LicensePlate getLicensePlate() {
        return licensePlate;
    }

    public MembershipLevel getMembershipLevel() {
        return membershipLevel;
    }

    public String getPassword() {
        return password;
    }
}