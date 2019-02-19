package com.vlstr.bcmbackend.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.vlstr.bcmbackend.domain.enums.Provider;

import java.io.Serializable;
import java.util.Date;

public class Flight implements Serializable {

    @JsonProperty(value = "provider")
    private Provider provider;
    @JsonProperty(value = "price")
    private double price;
    @JsonProperty(value = "departure_time")
    private Date departureTime;
    @JsonProperty(value = "arrival_time")
    private Date arrivalTime;

    public Flight() {
    }

    public Flight(Provider provider, double price, Date departureTime, Date arrivalTime) {
        this.provider = provider;
        this.price = price;
        this.departureTime = departureTime;
        this.arrivalTime = arrivalTime;
    }

    public Provider getProvider() {
        return provider;
    }

    public void setProvider(Provider provider) {
        this.provider = provider;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Date getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(Date departureTime) {
        this.departureTime = departureTime;
    }

    public Date getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(Date arrivalTime) {
        this.arrivalTime = arrivalTime;
    }
}
