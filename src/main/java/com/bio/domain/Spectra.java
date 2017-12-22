package com.bio.domain;

import java.util.List;

public class Spectra {

    List<Double> waweLength;
    List<Double> intensivity;

    public Spectra() {
    }

    public Spectra(List<Double> waweLength, List<Double> intensivity) {
        this.waweLength = waweLength;
        this.intensivity = intensivity;
    }

       public List<Double> getWaweLength() {
        return waweLength;
    }

    public void setWaweLength(List<Double> waweLength) {
        this.waweLength = waweLength;
    }

    public List<Double> getIntensivity() {
        return intensivity;
    }

    public void setIntensivity(List<Double> intensivity) {
        this.intensivity = intensivity;
    }
}
