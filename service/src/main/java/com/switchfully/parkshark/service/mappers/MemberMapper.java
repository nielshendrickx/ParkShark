package com.switchfully.parkshark.service.mappers;

import com.switchfully.parkshark.domain.user.member.MembershipLevel;
import com.switchfully.parkshark.domain.user.member.MembershipLevelRepository;
import com.switchfully.parkshark.domain.user.member.Member;
import com.switchfully.parkshark.service.user.CreateMemberDto;
import com.switchfully.parkshark.service.user.MemberDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.stream.Collectors;

@Component
public class MemberMapper {

    private MembershipLevelRepository membershipLevelRepository;

    @Autowired
    public MemberMapper(MembershipLevelRepository membershipLevelRepository) {
        this.membershipLevelRepository = membershipLevelRepository;
    }

    public MemberDto toDto (Member member) {
        return new MemberDto(
                member.getId(),
                member.getFirstName(),
                member.getLastName(),
                member.getMobilePhoneNumber(),
                member.getRegularPhoneNumber(),
                member.getEmail(),
                member.getAddress(),
                member.getLicensePlate(),
                member.getMembershipLevel(),
                member.getPassword(),
                member.getRegistrationDate());
    }

    public Member toMember (CreateMemberDto createMemberDto) {
        return new Member(
                createMemberDto.getFirstName(),
                createMemberDto.getLastName(),
                createMemberDto.getMobilePhoneNumber(),
                createMemberDto.getRegularPhoneNumber(),
                createMemberDto.getEmail(),
                createMemberDto.getAddress(),
                createMemberDto.getLicensePlate(),
                convertToMembership(createMemberDto.getMembershipLevelId()),
                createMemberDto.getPassword());
    }

    public Collection<MemberDto> toDto (Collection <Member> memberCollection) {
        return memberCollection.stream().map(this::toDto).collect(Collectors.toList());
    }

    private MembershipLevel convertToMembership(long membershipLevelId){
        if(membershipLevelId == 0){
           return membershipLevelRepository.findByName("Bronze");
        }
        return  membershipLevelRepository.findById(membershipLevelId);
    }
}
