package com.bio.dao;

import com.bio.domain.Project;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @author Mikhel Alexander on 20.11.2017 email mikhelas@altarix.ru .
 */
public interface ProjectDAO {

    List<Project> getProjects(@Param("user_id") Integer UserId);

    Project getProjectbyId(@Param("id") Integer id);

    int persist(Project project);

    int update(Project project);

    void delete(@Param("id") Integer id);
}
