package com.switchfully.parkshark;

import com.switchfully.parkshark.domain.user.Address;
import com.switchfully.parkshark.domain.user.Postal;
import com.switchfully.parkshark.domain.user.member.*;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
class MemberRepositoryTest {
    @Autowired
    private MemberRepository memberRepository;

    @Autowired
    private MembershipLevelRepository membershipLevelRepository;

    @Test
    void saveMember() {
        Postal postal = new Postal("1000", "Brussel");
        Address address = new Address("Wetstraat", "1", postal);
        LicensePlate licensePlate = new LicensePlate("1-aaa-111", "BE");
        Member member = new Member("firstName", "lastName", "0473000000", "016000000", "email@test.com", address, licensePlate, membershipLevelRepository.findByName("Bronze"), "password");
        Member actualValue = memberRepository.save(member);
        Assertions.assertThat(actualValue).isEqualTo(member);
        Assertions.assertThat(memberRepository.count()).isEqualTo(1);
    }

    @Test
    void saveThreeMembers_checkThatSizeIs3() {
        Postal postal = new Postal("1000", "Brussel");
        Address address = new Address("Wetstraat", "1", postal);
        LicensePlate licensePlate = new LicensePlate("1-aaa-111", "BE");
        Member member = new Member("firstName", "lastName", "0473000000", "016000000", "email@test.com", address, licensePlate, membershipLevelRepository.findByName("Bronze"), "password");
        Member member2 = new Member("firstName2", "lastName2", "0473000000", "016000000", "email2@test.com", address, licensePlate, membershipLevelRepository.findByName("Bronze"), "password");
        Member member3 = new Member("firstName3", "lastName3", "0473000000", "016000000", "email3@test.com", address, licensePlate, membershipLevelRepository.findByName("Bronze"), "password");
        memberRepository.save(member);
        memberRepository.save(member2);
        memberRepository.save(member3);
        Assertions.assertThat(memberRepository.count()).isEqualTo(3);
    }

    @Test
    void saveThreeMembers_checkThatEmailOfThirdIsRight() {
        Postal postal = new Postal("1000", "Brussel");
        Address address = new Address("Wetstraat", "1", postal);
        LicensePlate licensePlate = new LicensePlate("1-aaa-111", "BE");
        Member member = new Member("firstName", "lastName", "0473000000", "016000000", "email@test.com", address, licensePlate, membershipLevelRepository.findByName("Bronze"), "password");
        Member member2 = new Member("firstName2", "lastName2", "0473000000", "016000000", "email2@test.com", address, licensePlate, membershipLevelRepository.findByName("Bronze"), "password");
        Member member3 = new Member("firstName3", "lastName3", "0473000000", "016000000", "email3@test.com", address, licensePlate, membershipLevelRepository.findByName("Bronze"), "password");
        memberRepository.save(member);
        memberRepository.save(member2);
        memberRepository.save(member3);
        Member toCheck = memberRepository.findByEmail(member3.getEmail());
        Assertions.assertThat(toCheck).isNotEqualTo(null);
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

    @AfterEach
    void breakDown() {
        memberRepository.deleteAll();
        membershipLevelRepository.deleteAll();
    }
}