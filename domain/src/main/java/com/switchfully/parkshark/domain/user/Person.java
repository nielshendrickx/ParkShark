package com.switchfully.parkshark.domain.user;


import javax.persistence.*;

@Entity
@Table(name = "person")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "role", discriminatorType = DiscriminatorType.STRING)
public abstract class Person {

    @Id
    @Column(name = "id")
    private long id;

    @Column(name = "firstName")
    private String firstName;

    @Column(name = "lastName")
    private String lastName;

    @Column(name = "mobilePhoneNumber")
    private String mobilePhoneNumber;

    @Column(name = "regularPhoneNumber")
    private String regularPhoneNumber;

    @Column(name = "email")
    private String email;

    @ManyToOne
    @JoinColumn(name = "addressId")
    private Address addressId;

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getMobilePhoneNumber() {
        return mobilePhoneNumber;
    }

    public String getRegularPhoneNumber() {
        return regularPhoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public Address getAddressId() {
        return addressId;
    }
}