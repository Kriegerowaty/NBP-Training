package com.example.nbptraining.Xml;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;

import java.util.ArrayList;
import java.util.List;

public class Rates {
    @JacksonXmlElementWrapper(useWrapping = false)
    private List<Rate> Rate = new ArrayList<>();

    public List<com.example.nbptraining.Xml.Rate> getRate() {
        return Rate;
    }

    public void setRate(List<com.example.nbptraining.Xml.Rate> rate) {
        Rate = rate;
    }
}
