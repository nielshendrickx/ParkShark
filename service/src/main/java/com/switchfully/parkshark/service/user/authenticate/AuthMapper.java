package com.switchfully.parkshark.service.user.authenticate;

import com.switchfully.parkshark.domain.user.Person;
import org.springframework.stereotype.Component;

@Component
public class AuthMapper {
    public AuthDto toDto(Person person) {
        return new AuthDto(person.getEmail(), person.getPassword(), person.getRole());
    }
}
