package com.bio.domain;

import java.util.List;

public class Experiment {
    private String name;
    private List<Integer> spectraIds;
    private List<ExperimetParams> experimetParams;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Integer> getSpectraIds() {
        return spectraIds;
    }

    public void setSpectraIds(List<Integer> spectraIds) {
        this.spectraIds = spectraIds;
    }

    public List<ExperimetParams> getExperimetParams() {
        return experimetParams;
    }

    public void setExperimetParams(List<ExperimetParams> experimetParams) {
        this.experimetParams = experimetParams;
    }
}
