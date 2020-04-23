package com.switchfully.parkshark.domain.division;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DivisionRepository extends CrudRepository<Division,Long> {

    Division findById(long id);
    List<Division> findAll();

}
