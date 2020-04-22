package com.switchfully.parkshark.api.endpoints;

import com.switchfully.parkshark.service.services.ContactPersonService;
import com.switchfully.parkshark.service.user.CreateMemberDto;
import com.switchfully.parkshark.service.user.CreatePersonDto;
import com.switchfully.parkshark.service.user.PersonDto;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

import static com.switchfully.parkshark.api.validation.Validation.isValidEmailAddress;

@RestController
@RequestMapping(path = ContactPersonController.CONTACT_RESOURCE_PATH)

public class ContactPersonController {
    public static final String CONTACT_RESOURCE_PATH = "/contactperson";
    private final Logger loggerContactPerson = LoggerFactory.getLogger(ContactPersonController.class);
    private ContactPersonService contactPersonService;

    @Autowired
    public ContactPersonController(ContactPersonService contactPersonService) {
        this.contactPersonService = contactPersonService;
    }

    @PreAuthorize("hasAuthority('CREATE_CONTACT')")
    @PostMapping(consumes = "application/json", produces = "application/json")
    @ApiOperation(value = "Register a contact person", notes = "Create a contact person" , response = PersonDto.class)
    @ResponseStatus(HttpStatus.CREATED)
    public PersonDto register(@RequestBody CreatePersonDto createPersonDto) throws IOException {
        loggerContactPerson.info("Creating a new contact person");
        validateNewContact(createPersonDto);
        return contactPersonService.register(createPersonDto);
    }

    private void validateNewContact(CreatePersonDto createPersonDto) throws IOException {
        isValidEmailAddress(createPersonDto.getEmail());
        contactPersonService.isEmailAvailable(createPersonDto.getEmail());
    }

}
