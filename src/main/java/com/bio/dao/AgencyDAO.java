package com.bio.dao;

import com.bio.domain.Agency;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AgencyDAO {

    Agency getAgencyById (@Param("id") Long id);

    List<Agency> getList (@Param("profileId") Long profileId);

    void add (Agency agency);

    void update (Agency agency);

    void delete (@Param("id") Long id);


}
