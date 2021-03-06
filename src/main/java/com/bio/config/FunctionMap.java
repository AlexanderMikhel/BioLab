package com.bio.config;

import com.bio.algorithms.Algorithm;
import com.bio.algorithms.MultiplyingSpectraPointToFive;
import com.bio.algorithms.VRA;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class FunctionMap {

    private Map<String,Algorithm> functionMap;

    public FunctionMap(){
        functionMap = new HashMap<>();
        functionMap.put("vra",new VRA());
        functionMap.put("multiplyingSpectraPointToFive",new MultiplyingSpectraPointToFive());
    }

    public List<Algorithm> getAlgorithms(List<String> algoritmNameList){
        List<Algorithm> list = new ArrayList<>();
        for (String str:algoritmNameList) {
            list.add(functionMap.get(str));
        }
        return list;
    }

    public Map<String, Algorithm> getFunctionMap() {
        return functionMap;
    }

    public void setFunctionMap(Map<String, Algorithm> functionMap) {
        this.functionMap = functionMap;
    }
}
