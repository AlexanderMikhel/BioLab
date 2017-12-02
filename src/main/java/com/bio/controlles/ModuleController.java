package com.bio.controlles;


import com.bio.domain.Module;
import com.bio.domain.Profile;
import com.bio.service.ModuleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/modules")
public class ModuleController {

    @Autowired
    private ModuleService moduleService;

    @RequestMapping(method = RequestMethod.GET)
    public List<Module> getList(@RequestHeader("Profile") Profile profile,
                                @PathVariable("project_id") Long projectId) {
        return moduleService.getList(projectId);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Module getById(@PathVariable("id") Long id) {
        return moduleService.getById(id);
    }

    @RequestMapping(method = RequestMethod.POST)
    public void create(@PathVariable("project_id") Long projectId, @RequestBody Module module) {
        module.setProjectId(projectId);
        moduleService.add(module);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public Module update(@PathVariable("id") Long id,
                         @PathVariable("project_id") Long projectId,
                         @RequestBody Module module) {
        module.setId(id);
        module.setProjectId(projectId);
        return moduleService.update(module);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable Long id) {
        moduleService.delete(id);
    }

}
