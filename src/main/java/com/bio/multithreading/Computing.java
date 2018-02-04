package com.bio.multithreading;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Computing {
    private final ExecutorService executorService = Executors.newFixedThreadPool(4);

    public List<Object> compute(List<Object> objectList, List<String> nameFunction) {
        List<Object> resultList = new ArrayList<>();
        List<Divider> dividerList = new ArrayList<>();
        List<Future<Object>> futureList;
        for (Object object : objectList) {
            dividerList.add(new Divider(object,nameFunction));
        }
        try {
            futureList = executorService.invokeAll(dividerList);
            for (Future<Object> future : futureList) {
                if (future.isDone()) {
                    resultList.add(future.get());
                }
            }
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
        executorService.shutdown();
        return resultList;
    }
}
