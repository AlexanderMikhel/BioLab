package com.bio.dao;

import com.bio.domain.ScienceGroup;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ScienceGroupDAO {

    ScienceGroup getScienceGroupById(@Param("id")Long id);

    List<ScienceGroup> getList ();

    void add (ScienceGroup scienceGroup);

    void update (ScienceGroup scienceGroup);

    void delete (@Param("id") Long id);

}
