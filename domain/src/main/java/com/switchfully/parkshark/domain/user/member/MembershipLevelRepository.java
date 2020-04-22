package com.switchfully.parkshark.domain.user.member;

import org.springframework.data.repository.CrudRepository;

public interface MembershipLevelRepository extends CrudRepository<MembershipLevel, Long> {

    MembershipLevel findById(long id);
    MembershipLevel findByName(String name);
}
