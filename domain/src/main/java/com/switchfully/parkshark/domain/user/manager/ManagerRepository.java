package com.switchfully.parkshark.domain.user.manager;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ManagerRepository extends CrudRepository<Manager, Long> {
    List<Manager> findAll();

    Manager findByEmail(String email);
}
