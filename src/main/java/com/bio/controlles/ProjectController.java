package com.bio.controlles;

import com.bio.domain.Project;
import com.bio.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.List;

@RestController
@RequestMapping("/users/#{user_id}/projects")
public class ProjectController {

    @Autowired
    private ProjectService projectService;

    @RequestMapping(method = RequestMethod.GET)
    public List<Project> getList(@PathParam("user_id") Long userId){
        return projectService.getList(userId);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Project getById(@PathVariable("id") Long id) {
        return projectService.getById(id);
    }

    @RequestMapping(method = RequestMethod.POST)
    public void create(@PathParam("user_id") Long userId,
                       @RequestBody Project project){
        project.setId(userId);
        projectService.add(project);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public Project update(@PathParam("id") Long id,
                          @PathParam("user_id") Long userId,
                          @RequestBody Project project){
        project.setId(id);
        project.setUserId(userId);
        return projectService.update(project);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable("id") Long id){
        projectService.delete(id);
    }
}
