package com.bio.controlles;

import com.bio.domain.User;
import com.bio.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Mikhel Alexander on 19.11.2017 email mikhelas@altarix.ru .
 */

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(method = RequestMethod.GET)
    public List<User> getUsers(){
        return userService.getUsers();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public User getById(@PathVariable("id") Integer id) {
        return userService.getById(id);
    }

    @RequestMapping(method = RequestMethod.POST)
    public void create(@RequestBody User user){
        userService.add(user);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public User update(@PathVariable("id") Integer id,
                       @RequestBody User user){
        return userService.update(user);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable("id") Integer id){
        userService.delete(id);
    }
}
