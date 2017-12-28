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
    private AttachmentService attachmentService;

    @Autowired
    private FunctionMap functionMap;

   /* public void create(Experiment experiment){
        int iterarion = experiment.getSpectraIds().size();
        for(int i = 0; i<iterarion;i++) {
            Spectra s = (Spectra) functionMap.getFunctionMap()
                    .get(experiment.getExperimetParams().get(i).getFunctionName())
                    .run(attachmentService.getSpectraDataById(experiment.getSpectraIds().get(i)),
                            experiment.getExperimetParams().get(i).getParams());
        }
    }*/
}
