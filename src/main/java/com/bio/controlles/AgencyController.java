package com.bio.controlles;


import com.bio.domain.Agency;
import com.bio.domain.UserProfile;
import com.bio.service.AgencyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/agencies")
public class AgencyController {

    @Autowired
    private AgencyService agencyService;

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Agency getAgencyById(@PathVariable("id") Long id) {
        return agencyService.getAgencyById(id);
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<Agency> getList(@RequestHeader(value = "Profile") UserProfile profile) {
        return agencyService.getList(profile.getProfileId());
    }

    @RequestMapping(method = RequestMethod.POST)
    public void add(@RequestBody Agency agency) {
        agencyService.add(agency);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable("id") Long id) {
        agencyService.delete(id);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public Agency update(@PathVariable("id") Long id, @RequestBody Agency agency) {
        agency.setId(id);
        return agencyService.update(agency);
    }
}
