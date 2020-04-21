package com.switchfully.parkshark.service.mappers;

import com.switchfully.parkshark.service.user.CreateMemberDto;
import com.switchfully.parkshark.service.user.MemberDto;
import com.switchfully.parkshark.domain.user.member.Member;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class MemberMapper {
    public MemberDto toDto (Member member) {
        return new MemberDto(
                member.getId(),
                member.getFirstName(),
                member.getLastName(),
                member.getMobilePhoneNumber(),
                member.getRegularPhoneNumber(),
                member.getEmail(),
                member.getAddressId(),
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
                createMemberDto.getMembershipLevel(),
                createMemberDto.getPassword());
    }

    public Collection<MemberDto> toDto (Collection <Member> memberCollection) {
        return memberCollection.stream().map(this::toDto).collect(Collectors.toList());
    }
}
