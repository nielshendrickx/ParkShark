package com.switchfully.parkshark.domain.user.member;

import com.switchfully.parkshark.domain.user.Address;
import com.switchfully.parkshark.domain.user.Person;
import com.switchfully.parkshark.domain.user.Role;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@DiscriminatorValue(value = Role.Values.MEMBER)
public class Member extends Person {

    @Embedded
    private LicensePlate licensePlate;

    @Column(name = "registrationDate")
    private LocalDate registrationDate = LocalDate.now();

    @Embedded
    private MembershipLevel membershipLevel;

    @Column(name = "password")
    private String password;

    public Member() {
    }

    public Member(String firstName, String lastName, String mobilePhoneNumber, String regularPhoneNumber, String email, Address address, LicensePlate licensePlate, MembershipLevel membershipLevel, String password) {
        super(firstName,lastName,mobilePhoneNumber,regularPhoneNumber,email,address);
        this.licensePlate = licensePlate;
        this.membershipLevel = membershipLevel;
        this.password = password;
    }

    public Member(String firstName, String lastName, String mobilePhoneNumber, String regularPhoneNumber, String email, Address address, LicensePlate licensePlate, MembershipLevel membershipLevel, String password, LocalDate registrationDate) {
        super(firstName,lastName,mobilePhoneNumber,regularPhoneNumber,email,address);
        this.licensePlate = licensePlate;
        this.membershipLevel = membershipLevel;
        this.password = password;
        this.registrationDate = registrationDate;
    }

    public LicensePlate getLicensePlate() {
        return licensePlate;
    }

    public LocalDate getRegistrationDate() {
        return registrationDate;
    }

    public MembershipLevel getMembershipLevel() {
        return membershipLevel;
    }

    public String getPassword() {
        return password;
    }
}