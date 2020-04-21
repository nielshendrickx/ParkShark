package com.switchfully.parkshark.service.user;

import com.switchfully.parkshark.domain.user.Address;
import com.switchfully.parkshark.domain.user.member.LicensePlate;
import com.switchfully.parkshark.domain.user.member.MembershipLevel;

import java.time.LocalDate;

public class MemberDto extends PersonDto{
    private LicensePlate licensePlate;
    private MembershipLevel membershipLevel;
    private String password;
    private LocalDate registrationDate;

    public MemberDto(long id, String firstName, String lastName, String mobilePhoneNumber, String regularPhoneNumber, String email, Address address, LicensePlate licensePlate, MembershipLevel membershipLevel, String password, LocalDate registrationDate) {
        super(id, firstName, lastName, mobilePhoneNumber, regularPhoneNumber, email, address);
        this.licensePlate = licensePlate;
        this.membershipLevel = membershipLevel;
        this.password = password;
        this.registrationDate = registrationDate;
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

    public LocalDate getRegistrationDate() {
        return registrationDate;
    }
}
