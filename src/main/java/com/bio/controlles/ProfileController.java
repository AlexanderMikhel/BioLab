package com.bio.controlles;


import com.bio.domain.Profile;
import com.bio.exceptions.NotFoundProfileException;
import com.bio.service.ProfileService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RestController
@RequestMapping("/profiles")
public class ProfileController {

    private Logger logger = Logger.getLogger(ProfileController.class.getSimpleName());

    @Autowired
    private ProfileService profileService;

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Profile getProfileById(@PathVariable("id") Long id) throws NotFoundProfileException {
        if (profileService.getProfileById(id) == null) {
            throw new NotFoundProfileException();
        } else {
            return profileService.getProfileById(id);
        }
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

    @ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "The Profile is not found with this ID")
    @ExceptionHandler(NotFoundProfileException.class)
    public ModelAndView handlerNotFoundProfileException(Exception ex) {
        logger.error("Exception handler executed");
        ModelAndView modelAndView = new ModelAndView("error");
        modelAndView.addObject("error", ex.getMessage());
        return modelAndView;
    }
}
