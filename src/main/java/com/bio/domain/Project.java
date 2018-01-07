package com.bio.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class Project {

    @JsonIgnore
    private Long id;
    private String name;
    @JsonIgnore
    private Profile profile;

    public Profile getProfile() {
        return profile;
    }

    public void setProfile(Profile profile) {
        this.profile = profile;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
