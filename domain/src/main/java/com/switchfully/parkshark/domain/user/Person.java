package com.switchfully.parkshark.domain.user;


import com.switchfully.parkshark.domain.user.security.Role;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "person")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "role", discriminatorType = DiscriminatorType.STRING)
public abstract class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private long id;

    @Column(name = "firstName")
    private String firstName;

    @Column(name = "lastName")
    private String lastName;

    @Column(name = "email")
    private String email;

    @Column(name = "mobilePhoneNumber")
    private String mobilePhoneNumber;

    @Column(name = "regularPhoneNumber")
    private String regularPhoneNumber;

    @Embedded
    private Address address;

    public Person() {
    }

    public Person(String firstName, String lastName, String email, String mobilePhoneNumber, String regularPhoneNumber, Address address) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.mobilePhoneNumber = mobilePhoneNumber;
        this.regularPhoneNumber = regularPhoneNumber;
        this.address = address;
    }

    public long getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public String getMobilePhoneNumber() {
        return mobilePhoneNumber;
    }

    public String getRegularPhoneNumber() {
        return regularPhoneNumber;
    }

    public Address getAddress() {
        return address;
    }

    public String getPassword() {
        return "";
    }

    public Role getRole() {
        return Role.CONTACTPERSON;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return id == person.id &&
                Objects.equals(email, person.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, email);
    }
}