package com.example.nbptraining.Xml;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;

public class GoldPrice {
    @JacksonXmlElementWrapper(useWrapping = false)
    private String Data;
    @JacksonXmlElementWrapper(useWrapping = false)
    private String Price;

    public String getData() {
        return Data;
    }

    public void setData(String data) {
        Data = data;
    }

    public String getPrice() {
        return Price;
    }

    public void setPrice(String price) {
        Price = price;
    }
}
