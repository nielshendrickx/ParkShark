package com.switchfully.parkshark.domain;

import com.switchfully.parkshark.domain.user.Address;
import com.switchfully.parkshark.domain.user.Postal;
import com.switchfully.parkshark.domain.user.manager.Manager;
import com.switchfully.parkshark.domain.user.manager.ManagerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DummyData {
    ManagerRepository managerRepository;

    @Autowired
    public DummyData(ManagerRepository managerRepository) {
        this.managerRepository = managerRepository;
        Postal postal = new Postal("1000", "Brussel");
        Address address = new Address("Wetstraat", "1", postal);
        Manager manager = new Manager("man", "ager", "0473333333", "016808080", "manager2@parkshark.com", address, "manager");
        //managerRepository.save(manager);
    }
}
