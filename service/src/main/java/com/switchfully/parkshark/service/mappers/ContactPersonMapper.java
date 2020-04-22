package com.switchfully.parkshark.service.mappers;

import com.switchfully.parkshark.domain.user.contactperson.Contactperson;
import com.switchfully.parkshark.domain.user.contactperson.ContactpersonRepository;
import com.switchfully.parkshark.domain.user.member.Member;
import com.switchfully.parkshark.service.user.CreatePersonDto;
import com.switchfully.parkshark.service.user.MemberDto;
import com.switchfully.parkshark.service.user.PersonDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.stream.Collectors;

@Component
public class ContactPersonMapper {

    private ContactpersonRepository contactpersonRepository;

    @Autowired
    public ContactPersonMapper(ContactpersonRepository contactpersonRepository) {
        this.contactpersonRepository = contactpersonRepository;
    }

    public PersonDto toDto(Contactperson contactperson) {
        return new PersonDto(contactperson.getId(), contactperson.getFirstName(), contactperson.getLastName(), contactperson.getMobilePhoneNumber(), contactperson.getRegularPhoneNumber(), contactperson.getEmail(), contactperson.getAddress());
    }

    public Contactperson toContactPerson(CreatePersonDto createPersonDto) {
        return new Contactperson(createPersonDto.getFirstName(), createPersonDto.getLastName(), createPersonDto.getEmail(), createPersonDto.getMobilePhoneNumber(), createPersonDto.getRegularPhoneNumber(), createPersonDto.getAddress());
    }

    public Collection<PersonDto> toDto (Collection <Contactperson> contactpersonCollection) {
        return contactpersonCollection.stream().map(this::toDto).collect(Collectors.toList());
    }
}
