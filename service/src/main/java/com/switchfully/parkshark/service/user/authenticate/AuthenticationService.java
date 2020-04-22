package com.switchfully.parkshark.service.user.authenticate;

import com.switchfully.parkshark.domain.exceptions.AuthenticationFailedException;
import com.switchfully.parkshark.domain.user.Person;
import com.switchfully.parkshark.domain.user.manager.Manager;
import com.switchfully.parkshark.domain.user.manager.ManagerRepository;
import com.switchfully.parkshark.domain.user.member.MemberRepository;
import com.switchfully.parkshark.domain.user.security.Hash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AuthenticationService {
    private MemberRepository memberRepository;
    private ManagerRepository managerRepository;
    private AuthMapper authMapper;

    private List<Person> usersList = new ArrayList<>();

    @Autowired
    public AuthenticationService(MemberRepository memberRepository, ManagerRepository managerRepository, AuthMapper authMapper) {
        this.memberRepository = memberRepository;
        this.managerRepository = managerRepository;
        this.authMapper = authMapper;
    }

    public AuthDto authenticate(String email, String password) {
        usersList.addAll(memberRepository.findAll());
        usersList.addAll(managerRepository.findAll());
        return authMapper.toDto(authHelper(email,password));
    }

    private Person authHelper(String email, String password) {
        return usersList.stream()
                .filter(user -> user.getEmail().equals(email))
                .filter(user -> Hash.verifyHash(password, user.getPassword()))
                .findFirst()
                .orElseThrow(AuthenticationFailedException::new);
    }
}
