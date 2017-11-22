package com.bio.dao;

import com.bio.domain.User;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author Mikhel Alexander on 19.11.2017 email mikhelas@altarix.ru .
 */

public interface UserDAO {


    List<User> getUsers();

    @Select("SELECT id,name FROM users WHERE id = #{id} and deleted_at is null")
    User getUserbyId(@Param("id") Long id);

    @Insert("Insert into users(name) values(#{name})")
    @Options(useGeneratedKeys = true, keyColumn = "id", keyProperty = "id")
    void add(User user);

    @Update("UPDATE users SET name = #{name}, updated_at = now() WHERE id = #{id}")
    void update(User user);

    @Delete("UPDATE users SET deleted_at = now() WHERE id = #{id}")
    void delete(@Param("id") Long id);

}
