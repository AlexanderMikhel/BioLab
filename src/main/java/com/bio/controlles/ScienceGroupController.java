package com.bio.controlles;


import com.bio.domain.ScienceGroup;
import com.bio.service.ScienceGroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/scienceGroup")
public class ScienceGroupController {

    @Autowired
    private ScienceGroupService scienceGroupService;

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ScienceGroup getScienceGroupById(@PathVariable("id") Long id) {
        return scienceGroupService.getById(id);
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<ScienceGroup> getList() {
        return scienceGroupService.getList();
    }

    @RequestMapping(method = RequestMethod.POST)
    public void add(@RequestBody ScienceGroup scienceGroup) {
        scienceGroupService.add(scienceGroup);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ScienceGroup update(@PathVariable("id") Long id, @RequestBody ScienceGroup scienceGroup) {
        scienceGroup.setId(id);
        return scienceGroupService.update(scienceGroup);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable("id") Long id) {
        scienceGroupService.delete(id);
    }
}
