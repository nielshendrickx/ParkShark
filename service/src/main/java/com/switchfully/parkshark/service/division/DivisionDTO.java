package com.switchfully.parkshark.service.division;

import com.switchfully.parkshark.domain.division.Division;

public class DivisionDTO {

    private String name;

    private String originalName;

    private String director;

    public DivisionDTO(Division division) {
        this.name = division.getName();
        this.originalName = division.getOriginalName();
        this.director = division.getDirector();
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
