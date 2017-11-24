package com.bio.dao;

import com.bio.domain.Module;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface ModuleDAO {

    List<Module> getList(@Param("projectId") Long projectId);

    Module getById(@Param("id") Long id);

    void add(Module module);

    void update(Module module);

    void delete(@Param("id") Long id);

}
