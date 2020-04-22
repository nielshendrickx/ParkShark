package com.switchfully.parkshark.domain.exceptions;

public class AuthenticationFailedException extends RuntimeException {
    public AuthenticationFailedException() {
        super("Your password or email isn't correct.");
    }
}
