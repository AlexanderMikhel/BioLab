package com.bio.dao;

import com.bio.domain.Spectra;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author Mikhel Alexander on 04.01.2018 email mikhelas@altarix.ru .
 */
public interface SpectraDAO {

    @Insert("INSERT INTO spectra_data(profile_id,spectra,name) VALUES (#{profileId},#{stringPoints},#{name})")
    void saveSpectraDataFromFiles(Spectra spectra);


    Spectra get(@Param("id") Long id);

    List<Spectra> getList(@Param("ids") List<Long> ids);
}
