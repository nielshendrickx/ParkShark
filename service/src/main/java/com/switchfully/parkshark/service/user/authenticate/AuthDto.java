package com.switchfully.parkshark.service.user.authenticate;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.switchfully.parkshark.domain.user.security.Role;

import java.util.Objects;

public class AuthDto {

    private String email;
    private Role role;
    private String password;

    @JsonCreator
    public AuthDto(@JsonProperty("email") String email, @JsonProperty("password") String password, @JsonProperty("role") Role role) {
        this.email = email;
        this.role = role;
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public Role getRole() {
        return role;
    }

    public String getPassword() {
        return password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AuthDto authDto = (AuthDto) o;
        return Objects.equals(email, authDto.email) &&
                role == authDto.role &&
                Objects.equals(password, authDto.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(email, role, password);
    }
}
