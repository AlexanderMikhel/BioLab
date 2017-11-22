package com.bio.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * @author Mikhel Alexander on 19.11.2017 email mikhelas@altarix.ru .
 */
public class Project {
    private Long id;

    private String name;

    private User user;
    @JsonIgnore
    private Long userId;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
