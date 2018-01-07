package com.bio.dao;

import com.bio.domain.User;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;

import java.util.List;

public interface UserDAO {


    List<User> getList();


    User getUserbyId(@Param("id") Long id);


    void add(User user);


    void update(User user);


    void delete(@Param("id") Long id);
}
