package com.bio.domain;


import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * @author Mikhel Alexander on 19.11.2017 email mikhelas@altarix.ru .
 */
public class Module {
    private Long id;

    private String name;

    private Project project;

    @JsonIgnore
    private Long projectId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getProjectId() {
        return projectId;
    }

    public void setProjectId(Long projectId) {
        this.projectId = projectId;
    }
}
