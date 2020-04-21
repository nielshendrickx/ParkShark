package com.switchfully.parkshark.domain.exceptions;

public class DivisionDoesNotExistException extends RuntimeException {
    public DivisionDoesNotExistException(String message) {
        super(message);
    }
}
