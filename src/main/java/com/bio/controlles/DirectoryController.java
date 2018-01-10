package com.bio.controlles;

import com.bio.domain.Directory;
import com.bio.domain.UserProfile;
import com.bio.service.DirectoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Mikhel Alexander on 03.01.2018 email mikhelas@altarix.ru .
 */

@RestController
@RequestMapping("/directories")
public class DirectoryController {
    @Autowired
    private DirectoryService directoryService;

    @RequestMapping(method = RequestMethod.GET)
    public List<Directory> getList(@RequestHeader(value = "Profile") UserProfile user,
                                   @RequestParam(value = "ids") List<Long> ids,
                                   @RequestParam(value = "parent_id") Long parentId){
        return directoryService.getList(user.getUserId(),ids,parentId);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Directory get(@PathVariable("id") Long id) {
        return directoryService.get(id);
    }

    @RequestMapping(method = RequestMethod.POST)
    public void create(@RequestHeader(value = "Profile") UserProfile user,
                       @RequestBody Directory directory){
        directoryService.add(directory);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public Directory update(@PathVariable("id") Long id,
                            @RequestHeader(value = "Profile") UserProfile user,
                            @RequestBody Directory directory){
        return directoryService.update(directory);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable("id") Long id){
        directoryService.delete(id);
    }
}
