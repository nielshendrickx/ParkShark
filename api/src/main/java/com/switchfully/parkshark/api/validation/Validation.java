package com.switchfully.parkshark.api.validation;

import com.switchfully.parkshark.domain.division.DivisionRepository;
import com.switchfully.parkshark.domain.exceptions.DivisionDoesNotExistException;
import com.switchfully.parkshark.domain.exceptions.EmailNotValidException;
import org.springframework.beans.factory.annotation.Autowired;

public class Validation {
    @Autowired
    private static DivisionRepository divisionRepository;

    public static void isValidEmailAddress(String email) throws EmailNotValidException {
        String ePattern = "^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\])|(([a-zA-Z\\-0-9]+\\.)+[a-zA-Z]{2,}))$";
        java.util.regex.Pattern p = java.util.regex.Pattern.compile(ePattern);
        java.util.regex.Matcher m = p.matcher(email);
        if (!m.matches()) {
            throw new EmailNotValidException(email);
        }
    }

    public static void assertThatDivisionExists(int divisionId) {
        if(divisionRepository.findById(divisionId) == null){
            throw new DivisionDoesNotExistException(Integer.toString(divisionId));
        }
    }
}
