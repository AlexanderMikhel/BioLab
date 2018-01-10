package com.bio.dao;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface FileProcessorBeanDAO {

    @Select("Select * from get_directory_path_as_string(#{parentDirectoryId})")
    String getPath(@Param("parentDirectoryId") Long parentDirectoryId);

}
