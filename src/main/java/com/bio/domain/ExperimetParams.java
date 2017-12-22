package com.bio.domain;

import java.util.List;
import java.util.Map;

public class ExperimetParams {

    private String functionName;
    private List<Double> params;

    public String getFunctionName() {
        return functionName;
    }

    public void setFunctionName(String functionName) {
        this.functionName = functionName;
    }

    public List<Double> getParams() {
        return params;
    }

    public void setParams(List<Double> params) {
        this.params = params;
    }
}
