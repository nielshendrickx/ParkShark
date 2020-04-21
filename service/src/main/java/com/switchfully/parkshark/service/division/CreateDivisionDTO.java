package com.switchfully.parkshark.service.division;

import javax.validation.constraints.NotEmpty;

public class CreateDivisionDTO {

    @NotEmpty
    private String name;

    private String originalName;

    private String director;

    public CreateDivisionDTO(String name, String originalName, String director) {
        this.name = name;
        this.originalName = originalName;
        this.director = director;
    }

    public CreateDivisionDTO() {
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
