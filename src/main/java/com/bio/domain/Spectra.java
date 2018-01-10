package com.bio.domain;

import java.util.ArrayList;
import java.util.List;


public class Spectra {

    private Long id;
    private Long directoryId;
    private String name;
    private List<Point> points;
    private String StringPoints;

    public Spectra(){
        points = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStringPoints() {
        return StringPoints;
    }

    public void setStringPoints(String stringPoints) {
        StringPoints = stringPoints;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getDirectoryId() {
        return directoryId;
    }

    public void setDirectoryId(Long directoryId) {
        this.directoryId = directoryId;
    }

    public List<Point> getPoints() {
        return points;
    }

    public void setPoints(List<Point> points) {
        this.points = points;
    }
}
