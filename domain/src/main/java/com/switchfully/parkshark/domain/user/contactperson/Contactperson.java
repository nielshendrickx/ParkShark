package com.switchfully.parkshark.domain.user.contactperson;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.switchfully.parkshark.domain.user.Address;
import com.switchfully.parkshark.domain.user.Person;
import com.switchfully.parkshark.domain.user.security.Role;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue(value = Role.Values.CONTACTPERSON)
public class Contactperson extends Person {

    @Column(name = "mobilePhoneNumber")
    private String mobilePhoneNumber;

    @Column(name = "regularPhoneNumber")
    private String regularPhoneNumber;

    public Contactperson(@JsonProperty("firstName") String firstName, @JsonProperty("lastName") String lastName, @JsonProperty("mobilePhoneNumber") String mobilePhoneNumber, @JsonProperty("regularPhoneNumber") String regularPhoneNumber, @JsonProperty("email") String email, @JsonProperty("address") Address address) {
        super(firstName, lastName, email, address);
        this.mobilePhoneNumber = mobilePhoneNumber;
        this.regularPhoneNumber = regularPhoneNumber;
    }

    //todo: make a cleaner check of mobile phone or regular phone
    public Contactperson(@JsonProperty("firstName") String firstName, @JsonProperty("lastName") String lastName, @JsonProperty("mobilePhoneNumber") String anyPhone, @JsonProperty("email") String email, @JsonProperty("address") Address address) {
        super(firstName, lastName, email, address);
        if (anyPhone.length() == 10) {
            this.mobilePhoneNumber = anyPhone;
        }
        else this.regularPhoneNumber = anyPhone;
    }

    public String getMobilePhoneNumber() {
        return mobilePhoneNumber;
    }

    public String getRegularPhoneNumber() {
        return regularPhoneNumber;
    }

    public Contactperson() {
    }
}
