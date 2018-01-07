package com.bio.dao;

import com.bio.domain.Profile;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ProfileDAO{

    Profile getProfileById (@Param("id") Long id);

    List<Profile> getList ();

    void add (Profile profile);

    void update (Profile profile);

    void delete (@Param("id") Long id);

}
