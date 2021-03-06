package com.bio.controlles;

import com.bio.domain.User;
import com.bio.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(method = RequestMethod.GET)
    public List<User> getList() {
        return userService.getList();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public User getById(@PathVariable("id") Long id) {
        return userService.getById(id);
    }

    @RequestMapping(method = RequestMethod.POST)
    public void create(@RequestBody User user) {
        userService.add(user);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public User update(@PathVariable("id") Long id,
                       @RequestBody User user) {
        user.setId(id);
        return userService.update(user);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable("id") Long id) {
        userService.delete(id);
    }


}