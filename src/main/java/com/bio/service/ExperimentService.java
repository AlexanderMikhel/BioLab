package com.bio.service;

import com.bio.config.FunctionMap;
import com.bio.dao.ExperimentDAO;
import com.bio.domain.Experiment;
import com.bio.domain.Spectra;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ExperimentService {

    @Autowired
    private ExperimentDAO experimentDAO;

    @Autowired
    private FunctionMap functionMap;

    public void create(Experiment experiment){
        functionMap.getFunctionMap().get("vra").run(new Spectra(),);
    }
}
