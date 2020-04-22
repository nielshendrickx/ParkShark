package com.switchfully.parkshark.domain.user.contactperson;

import com.switchfully.parkshark.domain.user.member.Member;
import com.switchfully.parkshark.domain.user.member.MembershipLevel;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface  ContactpersonRepository extends CrudRepository<Contactperson, Long> {
    List<Contactperson> findAll();
    Contactperson findById(long id);
    Contactperson findByEmail(String email);
}
