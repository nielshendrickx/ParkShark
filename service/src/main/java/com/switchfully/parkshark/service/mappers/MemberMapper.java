package com.switchfully.parkshark.service.mappers;

import com.switchfully.parkshark.service.user.MemberDto;
import com.switchfully.parkshark.domain.user.member.Member;

public class MemberMapper {
    public MemberDto toDto (Member member) {
        return new MemberDto(member.getId(),member.getFirstName(),member.getLastName(),member.getMobilePhoneNumber(),member.getRegularPhoneNumber(),member.getEmail(),member.getAddressId(),member.getLicensePlate(),member.getMembershipLevel(),member.getPassword());
    }

    //to do: create address and pass into method, instead of only id
}
