package com.bio.controlles;


import com.bio.domain.Profile;
import com.bio.service.ProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/profiles")
public class ProfileController {

    @Autowired
    private ProfileService profileService;

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Profile getProfileById(@PathVariable("id") Long id) {
        return profileService.getProfileById(id);
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<Profile> getList() {
        return profileService.getList();
    }

    @RequestMapping(method = RequestMethod.POST)
    public void add(@RequestBody Profile profile) {
        profileService.add(profile);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public Profile update(@PathVariable("id") Long id, @RequestBody Profile profile) {
        profile.setId(id);
        return profileService.update(profile);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable("id") Long id) {
        profileService.delete(id);
    }

}
