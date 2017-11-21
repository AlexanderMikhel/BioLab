package com.bio.domain;

/**
 * @author Mikhel Alexander on 19.11.2017 email mikhelas@altarix.ru .
 */
public class Project {
    private Integer id;

    private String name;

    private User user;

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
}
