package com.bio.domain;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author Mikhel Alexander on 25.12.2017 email mikhelas@altarix.ru .
 */

public class Point {

    private Double intensity;
    @JsonProperty("wave_length")
    private Double waveLength;

    public Point(Double intensity, Double waveLength) {
        this.intensity = intensity;
        this.waveLength = waveLength;
    }
    public Point(){}

    public Double getIntensity() {
        return intensity;
    }

    public void setIntensity(Double intensity) {
        this.intensity = intensity;
    }

    public Double getWaveLength() {
        return waveLength;
    }

    public void setWaveLength(Double waveLength) {
        this.waveLength = waveLength;
    }
}
