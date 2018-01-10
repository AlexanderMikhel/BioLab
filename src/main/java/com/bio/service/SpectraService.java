package com.bio.service;

import com.bio.dao.SpectraDAO;
import com.bio.domain.Spectra;
import com.bio.utils.SpectraFileReader;
import com.bio.utils.StringConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

/**
 * @author Mikhel Alexander on 04.01.2018 email mikhelas@altarix.ru .
 */
@Component
public class SpectraService {

    @Autowired
    private SpectraDAO spectraDAO;

    @Autowired
    private SpectraFileReader spectraFileReader;

    @Autowired
    private StringConverter stringConverter;

    public void saveSpectraDataFromFiles(List<MultipartFile> files, Long profileId) throws IOException {
        List<Spectra> list = spectraFileReader.readFromFile(spectraFileReader.multipartToFile(files), profileId);
        for (Spectra s : list) {
            s.setStringPoints(stringConverter.convert(s.getPoints()));
            spectraDAO.saveSpectraDataFromFiles(s);
        }
    }

    public Spectra get(Long id) throws IOException {
        return  spectraDAO.get(id);
    }

    public List<Spectra> getList(List<Long> ids) throws IOException {
        return  spectraDAO.getList(ids);
    }



}
