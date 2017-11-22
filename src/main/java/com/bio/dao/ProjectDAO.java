package com.bio.dao;

import com.bio.domain.Project;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @author Mikhel Alexander on 20.11.2017 email mikhelas@altarix.ru .
 */
public interface ProjectDAO {

    List<Project> getList(@Param("userId") Long userId);

    Project getById(@Param("id") Long id);

    void add(Project project);

    void update(Project project);

    void delete(@Param("id") Long id);
}
