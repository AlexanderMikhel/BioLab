package com.bio.dao;

import com.bio.domain.Directory;
import com.bio.domain.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @author Mikhel Alexander on 03.01.2018 email mikhelas@altarix.ru .
 */
public interface DirectoryDAO {


    List<Directory> getList(@Param("userId") Long userId,
                            @Param("ids") List<Long> ids,
                            @Param("parentDirectoryId") Long parentDirectoryId); // исправить

    Directory get(@Param("id") Long id);

    @Select("Insert into directories(name,parent_directory_id,user_id,visibility_id) values(#{name},#{parentId},#{userId},1) returning id")
    @Options(useGeneratedKeys = true, keyColumn = "id", keyProperty = "id")
    Long add(Directory directory);

    @Update("UPDATE directories SET name = #{name},visibility_id = #{visibilityId},parent_id = #{parentId} updated_at = now() WHERE id = #{id}")
    void update(Directory directory);

    //доделывать
    @Delete("UPDATE directories SET deleted_at = now() WHERE id = #{id}")
    void delete(@Param("id") Long id);
}
