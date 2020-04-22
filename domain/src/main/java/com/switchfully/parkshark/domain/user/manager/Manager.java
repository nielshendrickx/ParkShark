package com.switchfully.parkshark.domain.user.manager;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.switchfully.parkshark.domain.user.Address;
import com.switchfully.parkshark.domain.user.Person;
import com.switchfully.parkshark.domain.user.security.Hash;
import com.switchfully.parkshark.domain.user.security.Role;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue(value = Role.Values.MANAGER)
public class Manager extends Person {

    @Column(name = "password")
    private String password;

    public Manager() {
    }

    public Manager(@JsonProperty("firstName") String firstName, @JsonProperty("lastName") String lastName, @JsonProperty("mobilePhoneNumber") String mobilePhoneNumber, @JsonProperty("regularPhoneNumber") String regularPhoneNumber, @JsonProperty("email") String email, @JsonProperty("address") Address address, @JsonProperty("password") String password) {
        super(firstName,lastName,mobilePhoneNumber,regularPhoneNumber,email,address);
        this.password = Hash.hash(password);
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public Role getRole() {
        return Role.MANAGER;
    }

}
