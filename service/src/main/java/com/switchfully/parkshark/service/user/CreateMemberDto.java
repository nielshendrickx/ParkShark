package com.switchfully.parkshark.service.user;

import com.switchfully.parkshark.domain.user.Address;
import com.switchfully.parkshark.domain.user.member.LicensePlate;
import com.switchfully.parkshark.domain.user.member.MembershipLevel;

import java.time.LocalDate;

public class CreateMemberDto extends CreatePersonDto {
    private LicensePlate licensePlate;
    private MembershipLevel membershipLevel;
    private String password;

    public CreateMemberDto(String firstName, String lastName, String mobilePhoneNumber, String regularPhoneNumber, String email, Address address, LicensePlate licensePlate, MembershipLevel membershipLevel, String password) {
        super(firstName, lastName, mobilePhoneNumber, regularPhoneNumber, email, address);
        this.licensePlate = licensePlate;
        this.membershipLevel = membershipLevel;
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