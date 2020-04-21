package com.switchfully.parkshark.domain.exceptions;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ExceptionTest {

    @Test
    void emailException_returnsCorrectMessage() {
        assertEquals("The provided email 'test' is not valid.", new EmailNotValidException("test").getMessage());
    }

    @Test
    void memberNotFoundException_returnsCorrectMessage() {
        assertEquals("Could not find the user.", new MemberNotFoundException().getMessage());
    }

    @Test
    void divisionDoesNotExistException_returnCorrectMessage() {
        assertEquals("Division with id: 1 does not exist", new DivisionDoesNotExistException("1").getMessage());
    }
}