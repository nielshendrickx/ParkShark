package com.switchfully.parkshark.domain.user.member;

import com.switchfully.parkshark.domain.user.Address;
import com.switchfully.parkshark.domain.user.Person;
import com.switchfully.parkshark.domain.user.security.Hash;
import com.switchfully.parkshark.domain.user.security.Role;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@DiscriminatorValue(value = Role.Values.MEMBER)
public class Member extends Person {

    @Embedded
    private LicensePlate licensePlate;

    @Column(name = "registrationDate")
    private LocalDate registrationDate = LocalDate.now();

    @OneToOne
    @JoinColumn(name = "fk_membershiplevel_id")
    private MembershipLevel membershipLevel;

    @Column(name = "password")
    private String password;

    public Member() {
    }

    //todo: is membershiplevel required in order to create a member? +create a test for this? Userstory: "Extend the Member registration so that upon registering a member we can choose to provide a membership level. However, it should still be possible to not provide one. In that case, we'll automatically set the membership level to bronze."
    public Member(String firstName, String lastName, String mobilePhoneNumber, String regularPhoneNumber, String email, Address address, LicensePlate licensePlate, MembershipLevel membershipLevel, String password) {
        super(firstName, lastName, email, mobilePhoneNumber, regularPhoneNumber, address);
        this.licensePlate = licensePlate;
        setMembershipLevel(membershipLevel);
        this.password = Hash.hash(password);
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

    public void setMembershipLevel(MembershipLevel membershipLevel) {
        this.membershipLevel = membershipLevel;
    }
}