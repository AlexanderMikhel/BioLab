package com.bio.service;

import com.bio.dao.ProjectDAO;
import com.bio.domain.Project;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectService {

    @Autowired
    private ProjectDAO projectDAO;


    public List<Project> getList(Long profileId){
        List<Project> L = projectDAO.getList(profileId);
        return L;
    }

    public Project getById(Long id) {
        return projectDAO.getById(id);
    }

    public void add(Project project){
        projectDAO.add(project);
    }

    public Project update(Project project){
        projectDAO.update(project);
        return getById(project.getId());
    }

    public void delete(Long id){
        projectDAO.delete(id);
    }
}
