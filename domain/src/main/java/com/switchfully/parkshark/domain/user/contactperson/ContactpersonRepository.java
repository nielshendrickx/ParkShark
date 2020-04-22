package com.switchfully.parkshark.domain.user.contactperson;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface  ContactpersonRepository extends CrudRepository<Contactperson, Long> {
    List<Contactperson> findAll();
}
