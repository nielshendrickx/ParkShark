package com.switchfully.parkshark.domain.user.member;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.switchfully.parkshark.domain.user.Address;
import com.switchfully.parkshark.domain.user.Person;
import com.switchfully.parkshark.domain.user.security.Hash;
import com.switchfully.parkshark.domain.user.security.Role;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@DiscriminatorValue(value = Role.Values.MEMBER)
public class Member extends Person {

    @Column(name = "mobilePhoneNumber")
    private String mobilePhoneNumber;

    @Column(name = "regularPhoneNumber")
    private String regularPhoneNumber;

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

    public Member(@JsonProperty("firstName") String firstName, @JsonProperty("lastName") String lastName, @JsonProperty("mobilePhoneNumber") String mobilePhoneNumber, @JsonProperty("regularPhoneNumber") String regularPhoneNumber, @JsonProperty("email") String email, @JsonProperty("address") Address address, @JsonProperty("licensePlate") LicensePlate licensePlate, @JsonProperty("membershipLevel") MembershipLevel membershipLevel, @JsonProperty("password") String password) {
        super(firstName, lastName, email, mobilePhoneNumber, regularPhoneNumber, address);
        this.mobilePhoneNumber = mobilePhoneNumber;
        this.regularPhoneNumber = regularPhoneNumber;
        this.licensePlate = licensePlate;
        this.membershipLevel = membershipLevel;
        this.password = Hash.hash(password);
    }


    public String getMobilePhoneNumber() {
        return mobilePhoneNumber;
    }

    public String getRegularPhoneNumber() {
        return regularPhoneNumber;
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

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public Role getRole() {
        return Role.MEMBER;
    }


}