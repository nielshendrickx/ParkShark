package com.switchfully.parkshark.domain.user.contactperson;

import com.switchfully.parkshark.domain.user.Person;
import com.switchfully.parkshark.domain.user.Role;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue(value = Role.Values.CONTACTPERSON)
public class Contactperson extends Person {

    public Contactperson() {
    }
}
