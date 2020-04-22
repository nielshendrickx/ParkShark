package com.switchfully.parkshark;

import com.switchfully.parkshark.domain.user.Address;
import com.switchfully.parkshark.domain.user.Postal;
import com.switchfully.parkshark.domain.user.member.*;
import com.switchfully.parkshark.service.services.MemberService;
import com.switchfully.parkshark.service.user.CreateMemberDto;
import com.switchfully.parkshark.service.user.MemberDto;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.Collection;

@SpringBootTest
class MemberServiceTest {

    @Autowired
    private MemberService memberService;

    @Autowired
    private MembershipLevelRepository membershipLevelRepository;

    @Autowired
    private MemberRepository memberRepository;

    @Test
    void whenCreateMemberDtoIsSaved_checkThatReturnMemberDto() {
        Postal postal = new Postal("1000", "Brussel");
        Address address = new Address("Wetstraat", "1", postal);
        LicensePlate licensePlate = new LicensePlate("1-aaa-111", "BE");
        CreateMemberDto createMemberDto = new CreateMemberDto("firstName", "lastName", "0473000000", "016000000", "email@test.com", address, licensePlate,"password", 1);
        MemberDto memberDto = memberService.register(createMemberDto);
        Assertions.assertThat(memberDto.getFirstName()).isEqualTo("firstName");
        Assertions.assertThat(memberDto.getLastName()).isEqualTo("lastName");
        Assertions.assertThat(memberDto.getRegistrationDate()).isEqualTo(LocalDate.now());
    }

    @Test
    void getAllMembers() {
        Postal postal = new Postal("1000", "Brussel");
        Address address = new Address("Wetstraat", "1", postal);
        LicensePlate licensePlate = new LicensePlate("1-aaa-111", "BE");

        Member member = new Member("firstName", "lastName", "0473000000", "016000000", "email@test.com", address, licensePlate, membershipLevelRepository.findByName("Bronze") , "password");
        memberRepository.save(member);
        Collection<MemberDto> memberDtoList = memberService.getAllMembers();
        Assertions.assertThat(memberDtoList).hasSize(1);
    }

    @AfterEach
    void breakDown() {
        memberRepository.deleteAll();
    }

    @BeforeEach
    void fillDefaultMemberShips() {
        MembershipLevel membershipLevelBronze = new MembershipLevel("Bronze", 0.0, 0.0,4);
        membershipLevelRepository.save(membershipLevelBronze);
        MembershipLevel membershipLevelSilver = new MembershipLevel("Silver", 10.0, 0.2,6);
        membershipLevelRepository.save(membershipLevelSilver);
        MembershipLevel membershipLevelGold = new MembershipLevel("Gold", 40.0, 0.3,24);
        membershipLevelRepository.save(membershipLevelGold);
    }

 }