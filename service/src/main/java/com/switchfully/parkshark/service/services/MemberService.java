package com.switchfully.parkshark.service.services;

import com.switchfully.parkshark.domain.exceptions.EmailAlreadyRegisteredException;
import com.switchfully.parkshark.domain.user.member.MemberRepository;
import com.switchfully.parkshark.service.mappers.MemberMapper;
import com.switchfully.parkshark.service.user.CreateMemberDto;
import com.switchfully.parkshark.service.user.MemberDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class MemberService {
    private MemberRepository memberRepository;
    private MemberMapper memberMapper;

    @Autowired
    public MemberService(MemberRepository memberRepository, MemberMapper memberMapper) {
        this.memberRepository = memberRepository;
        this.memberMapper = memberMapper;
    }

    public Collection<MemberDto> getAllMembers() {
        return memberMapper.toDto(memberRepository.findAll());
    }

    public MemberDto register(CreateMemberDto newMember) {
        return memberMapper.toDto(memberRepository.save(memberMapper.toMember(newMember)));
    }

    public void isEmailAvailable(String email) throws EmailAlreadyRegisteredException {
        if (memberRepository.findByEmail(email) != null) {
            throw new EmailAlreadyRegisteredException(email);
        }
    }
}
