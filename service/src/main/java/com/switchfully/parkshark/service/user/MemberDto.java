package com.switchfully.parkshark.service.user;

import com.switchfully.parkshark.domain.user.Address;
import com.switchfully.parkshark.domain.user.member.LicensePlate;
import com.switchfully.parkshark.domain.user.member.MembershipLevel;

public class MemberDto extends PersonDto{
    private LicensePlate licensePlate;
    private MembershipLevel membershipLevel;
    private String password;

    public MemberDto(long id, String firstName, String lastName, String mobilePhoneNumber, String regularPhoneNumber, String email, Address address, LicensePlate licensePlate, MembershipLevel membershipLevel, String password) {
        super(id, firstName, lastName, mobilePhoneNumber, regularPhoneNumber, email, address);
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
