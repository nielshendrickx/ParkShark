package com.switchfully.parkshark.domain.user.manager;

import com.switchfully.parkshark.domain.user.Person;
import com.switchfully.parkshark.domain.user.security.Role;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue(value = Role.Values.MANAGER)
public class Manager extends Person {

    public Manager() {
    }
}
