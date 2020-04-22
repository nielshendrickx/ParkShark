package com.switchfully.parkshark.api.exceptions;


import com.switchfully.parkshark.api.endpoints.DivisionController;
import com.switchfully.parkshark.api.endpoints.MemberController;
import com.switchfully.parkshark.domain.exceptions.DivisionDoesNotExistException;
import com.switchfully.parkshark.domain.exceptions.EmailNotValidException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.UUID;


@ControllerAdvice
public class ControllerExceptionHandler extends ResponseEntityExceptionHandler {

    private final Logger loggerMember = LoggerFactory.getLogger(MemberController.class);
    private final Logger loggerDivision = LoggerFactory.getLogger(DivisionController.class);

    @ExceptionHandler(EmailNotValidException.class)
    protected void emailNotValidException(EmailNotValidException ex, HttpServletResponse response) throws IOException {
        loggerMember.error("Email is not valid!", ex);
        response.sendError(HttpStatus.BAD_REQUEST.value(), ex.getMessage());
    }

    @ExceptionHandler(DivisionDoesNotExistException.class)
    protected void divisionDoesNotExistException(DivisionDoesNotExistException exception, HttpServletResponse response) throws IOException {
        loggerDivision.warn("Log Id: " + UUID.randomUUID() + " - " + exception.getMessage(), exception);
        response.sendError(HttpStatus.BAD_REQUEST.value(), exception.getMessage());
    }

}
