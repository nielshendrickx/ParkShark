package com.switchfully.parkshark.domain.exceptions;

public class MemberNotFoundException extends RuntimeException {
    public MemberNotFoundException() {
        super("Could not find the user.");
    }
}