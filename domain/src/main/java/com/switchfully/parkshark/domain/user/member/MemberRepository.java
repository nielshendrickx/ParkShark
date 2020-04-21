package com.switchfully.parkshark.domain.user.member;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface MemberRepository extends CrudRepository<Member, Long> {
    List<Member> findAll();

    Member findByEmail(String email);
}
