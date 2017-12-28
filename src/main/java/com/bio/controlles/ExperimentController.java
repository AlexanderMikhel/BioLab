package com.bio.controlles;
import com.bio.domain.Experiment;
import com.bio.service.ExperimentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/experiments")
public class ExperimentController {

       @Autowired
    private ExperimentService experimentService;

    @RequestMapping(method = RequestMethod.POST)
    public void create(@RequestBody Experiment experiment) {
        //experimentService.create(experiment);
    }

    @RequestMapping(method = RequestMethod.GET,value = "/spectra")
    public void getSpectraById(Integer id){

    }
}
