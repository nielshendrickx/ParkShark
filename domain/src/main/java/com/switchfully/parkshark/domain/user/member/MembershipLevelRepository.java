package com.switchfully.parkshark.domain.user.member;

import org.springframework.data.repository.CrudRepository;

public interface MembershipLevelRepository extends CrudRepository<MembershipLevel, Long> {

    MembershipLevel findById(int id);
    MembershipLevel findByName(String name);
}
