package com.switchfully.parkshark.service.division;

import com.switchfully.parkshark.domain.division.Division;

public class DivisionDTO {

    private long id;

    private String name;

    private String originalName;

    private String director;

    public DivisionDTO(Division division) {
        this.id = division.getId();
        this.name = division.getName();
        this.originalName = division.getOriginalName();
        this.director = division.getDirector();
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getOriginalName() {
        return originalName;
    }

    public String getDirector() {
        return director;
    }
}
