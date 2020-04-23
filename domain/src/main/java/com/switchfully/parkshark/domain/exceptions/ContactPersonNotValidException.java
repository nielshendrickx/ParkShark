package com.switchfully.parkshark.domain.exceptions;

public class ContactPersonNotValidException extends RuntimeException {
    public ContactPersonNotValidException() {
        super("Contact person not valid! Please fill in a mobile or a regular phone number.");
    }
}
