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

    @Insert("Insert into projects(name) values(#{name})")
    @Options(useGeneratedKeys = true, keyColumn = "id", keyProperty = "id")
    int persist(Project project);

    @Update("UPDATE projects SET name = #{name},user_id = #{userId}, updated_at = now() WHERE id = #{project.id}")
    int update(Project project);

    @Delete("UPDATE projects SET deleted_at = now() WHERE id = #{id}")
    void delete(@Param("id") Integer id);
}
