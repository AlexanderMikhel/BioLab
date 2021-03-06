package com.bio.service;

import com.bio.dao.UserDAO;
import com.bio.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Mikhel Alexander on 19.11.2017 email mikhelas@altarix.ru .
 */
@Service
public class UserService {

    @Autowired
    private UserDAO userDAO;

    public List<User> getList(){
        List<User> L = userDAO.getList();
        return L;
    }

    public User getById(Long id){
        return userDAO.getUserbyId(id);
    }

    public void add(User user){
        userDAO.add(user);
    }

    public User update(User user){
        userDAO.update(user);
        return userDAO.getUserbyId(user.getId());
    }

    public void delete(Long id){
        userDAO.delete(id);
    }
}
