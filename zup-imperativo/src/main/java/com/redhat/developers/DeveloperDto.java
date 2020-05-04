package com.redhat.developers;

public class DeveloperDto {
    private String name;

    private DeveloperDto(Developer developer) {
        this.name = developer.name;
    }

    public static DeveloperDto of(Developer developer){
        return new DeveloperDto(developer);
    }

    public String getName() {
        return name;
    }
}
