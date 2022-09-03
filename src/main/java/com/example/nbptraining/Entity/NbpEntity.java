package com.example.nbptraining.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class NbpEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String currency;
    private String startDate;
    private String endDate;
    private float goldExchange;
    private String whenDone;

    public NbpEntity(String currency, String startDate, String endDate, float goldExchange, String whenDone) {
        this.currency = currency;
        this.startDate = startDate;
        this.endDate = endDate;
        this.goldExchange = goldExchange;
        this.whenDone = whenDone;
    }

    public NbpEntity() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public float getGoldExchange() {
        return goldExchange;
    }

    public void setGoldExchange(float goldExchange) {
        this.goldExchange = goldExchange;
    }

    public String getWhenDone() {
        return whenDone;
    }

    public void setWhenDone(String whenDone) {
        this.whenDone = whenDone;
    }

    @Override
    public String toString() {
        return "{" +
                "id=" + id +
                ", Waluta='" + currency + '\'' +
                ", Od='" + startDate + '\'' +
                ", Do='" + endDate + '\'' +
                ", kurs Złota=" + goldExchange +
                ", Wykonano='" + whenDone + '\'' +
                '}';
    }
}
