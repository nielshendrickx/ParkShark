package com.switchfully.parkshark.service.services;

import com.switchfully.parkshark.domain.exceptions.EmailAlreadyRegisteredException;
import com.switchfully.parkshark.domain.user.contactperson.ContactpersonRepository;
import com.switchfully.parkshark.service.mappers.ContactPersonMapper;
import com.switchfully.parkshark.service.user.CreatePersonDto;
import com.switchfully.parkshark.service.user.PersonDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ContactPersonService {
    private ContactpersonRepository contactpersonRepository;
    private ContactPersonMapper contactPersonMapper;

    @Autowired

    public ContactPersonService(ContactpersonRepository contactpersonRepository, ContactPersonMapper contactPersonMapper) {
        this.contactpersonRepository = contactpersonRepository;
        this.contactPersonMapper = contactPersonMapper;
    }

    public PersonDto register(CreatePersonDto createPersonDto) {
        return contactPersonMapper.toDto(contactpersonRepository.save(contactPersonMapper.toContactPerson(createPersonDto)));
    }

    public void isEmailAvailable(String email) throws EmailAlreadyRegisteredException {
        if (contactpersonRepository.findByEmail(email) != null) {
            throw new EmailAlreadyRegisteredException(email);
        }
    }
}
