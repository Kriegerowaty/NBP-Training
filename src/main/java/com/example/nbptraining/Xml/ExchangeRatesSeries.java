package com.example.nbptraining.Xml;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;

import java.util.ArrayList;
import java.util.List;

public class ExchangeRatesSeries {
    @JacksonXmlElementWrapper(useWrapping = false)
    private String Table;
    @JacksonXmlElementWrapper(useWrapping = false)
    private String Currency;
    @JacksonXmlElementWrapper(useWrapping = false)
    private String Code;

    @JacksonXmlElementWrapper(useWrapping = false)
    private List<Rates> Rates = new ArrayList<>();

    public String getTable() {
        return Table;
    }

    public void setTable(String table) {
        Table = table;
    }

    public String getCurrency() {
        return Currency;
    }

    public void setCurrency(String currency) {
        Currency = currency;
    }

    public String getCode() {
        return Code;
    }

    public void setCode(String code) {
        Code = code;
    }


    public void setRates(List<Rates> rates) {
        Rates = rates;
    }

    public List<com.example.nbptraining.Xml.Rates> getRates(){
        return Rates;
    }

    public float getCurrencyCourse(){
        List<Rates> ratesList = getRates();
        List<Rate> rateList = ratesList.get(0).getRate();
        return Float.parseFloat(rateList.get(0).getMid());
    }
}
