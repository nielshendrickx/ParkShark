package com.switchfully.parkshark.api.validation;

import com.switchfully.parkshark.domain.exceptions.ContactPersonNotValidException;
import com.switchfully.parkshark.domain.exceptions.EmailNotValidException;
import com.switchfully.parkshark.service.services.DivisionService;
import com.switchfully.parkshark.service.user.CreatePersonDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Validation {

    private DivisionService divisionService;

    @Autowired
    public Validation(DivisionService divisionService) {
        this.divisionService = divisionService;
    }

    public static void isValidEmailAddress(String email) throws EmailNotValidException {
        String ePattern = "^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\])|(([a-zA-Z\\-0-9]+\\.)+[a-zA-Z]{2,}))$";
        java.util.regex.Pattern p = java.util.regex.Pattern.compile(ePattern);
        java.util.regex.Matcher m = p.matcher(email);
        if (!m.matches()) {
            throw new EmailNotValidException(email);
        }
    }

    public static void assertThatContactPersonIsValid(CreatePersonDto createPersonDto) {
        if(createPersonDto.getMobilePhoneNumber() == null && createPersonDto.getRegularPhoneNumber() == null) {
            throw new ContactPersonNotValidException();
        }
    }

    public void assertThatDivisionExists(long divisionId) {
        divisionService.assertThatDivisionExists(divisionId);
    }
}
