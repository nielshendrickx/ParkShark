package com.switchfully.parkshark.domain.division;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DivisionRepository extends CrudRepository<Division,Integer> {

    Division findById(int id);

}
