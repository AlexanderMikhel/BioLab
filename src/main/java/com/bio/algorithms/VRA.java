package com.bio.algorithms;

import com.bio.domain.Spectra;

import java.util.List;
import java.util.stream.Collectors;

public class VRA implements Algorithm<Spectra,Double> {

    @Override
    public Spectra run(Spectra spectra, Double[] params) {
        List<Double> newIntensivity = spectra.getIntensivity().stream().filter(i->i<10).collect(Collectors.toList());
        List<Double> newWaveLength = spectra.getWaweLength().stream().filter(w->w<10).collect(Collectors.toList());
        return new Spectra(newIntensivity,newWaveLength);
    }
}
