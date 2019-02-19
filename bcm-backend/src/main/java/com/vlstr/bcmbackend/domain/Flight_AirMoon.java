package com.vlstr.bcmbackend.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.util.Date;

public class Flight_AirMoon implements Serializable {

    @JsonProperty(value = "id")
    private String id;
    @JsonProperty(value = "price")
    private double price;
    @JsonProperty(value = "departure_time")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "HH:mm a")
    private Date departureTime;
    @JsonProperty(value = "arrival_time")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "HH:mm a")
    private Date arrivalTime;

    public Flight_AirMoon() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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
