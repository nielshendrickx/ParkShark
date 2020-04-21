package com.switchfully.parkshark.domain.exceptions;

public class EmailNotValidException extends Throwable {
    public EmailNotValidException(String email) {super("The provided email '"+email+"' is not valid.");
    }
}
