package com.bio.dao;

import com.bio.domain.Project;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface ProjectDAO {

    List<Project> getList(@Param("profileId") Long profileId);

    Project getById(@Param("id") Long id);

    void add(Project project);

    void update(Project project);

    void delete(@Param("id") Long id);
}
