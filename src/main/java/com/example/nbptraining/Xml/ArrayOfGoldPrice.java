package com.example.nbptraining.Xml;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;

import java.util.ArrayList;
import java.util.List;


public class ArrayOfGoldPrice {
    @JacksonXmlElementWrapper(useWrapping = false)
    private List<GoldPrice> GoldPrice = new ArrayList<>();

    public List<com.example.nbptraining.Xml.GoldPrice> getGoldPrice() {
        return GoldPrice;
    }

    public void setGoldPrice(List<com.example.nbptraining.Xml.GoldPrice> goldPrice){
        GoldPrice = goldPrice;
    }

    public float getAvgGoldPrice(float priceCurrency) {
        List<GoldPrice> goldPriceList = getGoldPrice();
        int elements = goldPriceList.size();
        float sum = 0;

        for(int i=0; i<=elements-1; i++) {
            sum += Float.parseFloat(goldPriceList.get(i).getPrice());
        }

        return (sum/elements)*priceCurrency;
    }
}
