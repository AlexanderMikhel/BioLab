package com.bio.controlles;

import com.bio.domain.Project;
import com.bio.domain.UserProfile;
import com.bio.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.List;

@RestController
@RequestMapping("/projects")
public class ProjectController {

    @Autowired
    private ProjectService projectService;

    @RequestMapping(method = RequestMethod.GET)
    public List<Project> getList(@RequestHeader(value = "Profile") UserProfile profile) {
        return projectService.getList(profile.getProfileId());
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Project getById(@PathVariable("id") Long id) {
        return projectService.getById(id);
    }

    @RequestMapping(method = RequestMethod.POST)
    public void add(@RequestBody Project project) {
        projectService.add(project);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public Project update(@PathVariable("id") Long id,
                          @RequestBody Project project) {
        project.setId(id);
        return projectService.update(project);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable("id") Long id) {
        projectService.delete(id);
    }
}
