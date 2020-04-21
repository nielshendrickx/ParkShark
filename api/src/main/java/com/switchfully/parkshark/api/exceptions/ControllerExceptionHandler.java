package com.switchfully.parkshark.api.exceptions;


import com.switchfully.parkshark.api.endpoints.MemberController;
import com.switchfully.parkshark.domain.exceptions.EmailNotValidException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import com.switchfully.parkshark.domain.exceptions.DivisionDoesNotExistException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.UUID;


@ControllerAdvice
public class ControllerExceptionHandler extends ResponseEntityExceptionHandler {

    private final Logger loggerMember = LoggerFactory.getLogger(MemberController.class);

    @ExceptionHandler(EmailNotValidException.class)
    protected void emailNotValidException(EmailNotValidException ex, HttpServletResponse response) throws IOException {
        loggerMember.error("Email is not valid!", ex);
        response.sendError(HttpStatus.BAD_REQUEST.value(), ex.getMessage());
    }
    private final Logger LOGGER = LoggerFactory.getLogger(ControllerExceptionHandler.class);

    @ExceptionHandler(DivisionDoesNotExistException.class)
    protected void userAlreadyExistsException(DivisionDoesNotExistException exception, HttpServletResponse response) throws IOException {
        LOGGER.warn("Log Id: " + UUID.randomUUID() + " - " + exception.getMessage(), exception);
        response.sendError(HttpStatus.BAD_REQUEST.value(), exception.getMessage());
    }

}
