package com.switchfully.parkshark.domain.user.contactperson;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.switchfully.parkshark.domain.user.Address;
import com.switchfully.parkshark.domain.user.Person;
import com.switchfully.parkshark.domain.user.security.Role;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
//todo: create contact person dto
@Entity
@DiscriminatorValue(value = Role.Values.CONTACTPERSON)
public class Contactperson extends Person {

    public Contactperson(@JsonProperty("firstName") String firstName, @JsonProperty("lastName") String lastName, @JsonProperty("email") String email, @JsonProperty("mobilePhoneNumber") String mobilePhoneNumber, @JsonProperty("regularPhoneNumber") String regularPhoneNumber, @JsonProperty("address") Address address) {
        super(firstName, lastName, email, mobilePhoneNumber, regularPhoneNumber, address);

    }

    public Contactperson() {
    }
}
