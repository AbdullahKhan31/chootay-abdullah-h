package com.chootay.dtos;

import javax.persistence.Column;

public class Bike_ReadDTO {
    private int bike_id;
    private String model;
    private double price;
    private int quantity;

    public Bike_ReadDTO() {
    }

    public Bike_ReadDTO(int bike_id, String model, double price, int quantity) {
        this.bike_id = bike_id;
        this.model = model;
        this.price = price;
        this.quantity = quantity;
    }

    public int getBike_id() {
        return bike_id;
    }

    public void setBike_id(int bike_id) {
        this.bike_id = bike_id;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
