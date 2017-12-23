package com.bio.config;

import com.bio.algorithms.Algorithm;
import com.bio.algorithms.VRA;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class FunctionMap {
    private Map<String,Algorithm> functionMap;

    public FunctionMap(){
        functionMap.put("vra",new VRA());
    }

    public Map<String, Algorithm> getFunctionMap() {
        return functionMap;
    }

    public void setFunctionMap(Map<String, Algorithm> functionMap) {
        this.functionMap = functionMap;
    }

    public List<Algorithm>
}
