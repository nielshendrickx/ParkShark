package com.switchfully.parkshark.domain.exceptions;

public class DivisionDoesNotExistException extends RuntimeException {
    public DivisionDoesNotExistException(String divisionId) {
        super(String.format("Division with id: %s does not exist", divisionId));
    }
}
