package com.switchfully.parkshark.service.user;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.switchfully.parkshark.domain.user.Address;
import com.switchfully.parkshark.domain.user.member.LicensePlate;

public class CreateMemberDto extends CreatePersonDto {
    private LicensePlate licensePlate;
    private int membershipLevelId;
    private String password;

    @JsonCreator
    public CreateMemberDto(@JsonProperty("firstName") String firstName, @JsonProperty("lastName") String lastName, @JsonProperty("mobilePhoneNumber") String mobilePhoneNumber, @JsonProperty("regularPhoneNumber") String regularPhoneNumber, @JsonProperty("email") String email, @JsonProperty("address") Address address, @JsonProperty("licensePlate") LicensePlate licensePlate, @JsonProperty("password") String password,  @JsonProperty("membershipLevelId") int membershipLevelId) {
        super(firstName, lastName, mobilePhoneNumber, regularPhoneNumber, email, address);
        this.licensePlate = licensePlate;
        this.membershipLevelId = membershipLevelId;
        this.password = password;
    }

    public LicensePlate getLicensePlate() {
        return licensePlate;
    }

    public int getMembershipLevelId() {
        return membershipLevelId;
    }

    public String getPassword() {
        return password;
    }
}