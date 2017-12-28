package com.bio.domain;

/**
 * @author Mikhel Alexander on 25.12.2017 email mikhelas@altarix.ru .
 */
public class Point {

    private Double intensity;
    private Double waveLenght;

    public Point(Double intensity, Double waveLenght) {
        this.intensity = intensity;
        this.waveLenght = waveLenght;
    }

    public Double getIntensity() {
        return intensity;
    }

    public void setIntensity(Double intensity) {
        this.intensity = intensity;
    }

    public Double getWaveLenght() {
        return waveLenght;
    }

    public void setWaveLenght(Double waveLenght) {
        this.waveLenght = waveLenght;
    }
}
