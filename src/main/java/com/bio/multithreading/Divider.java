package com.bio.multithreading;

import com.bio.config.FunctionMap;
import com.bio.domain.Spectra;

import java.util.List;
import java.util.concurrent.Callable;

public class Divider implements Callable<Object> {

   Object obj;
    FunctionMap function = new FunctionMap();
    List<String> listNameFunctions;

    public Divider(Object obj, List<String> listNameFunctions) {
        this.listNameFunctions = listNameFunctions;
        this.obj = obj;
    }

    @Override
    public Object call() throws Exception {
        for (String name : listNameFunctions) {
            obj = (( function.getFunctionMap().get(name)).run(obj));
        }
        return obj;
    }
}
