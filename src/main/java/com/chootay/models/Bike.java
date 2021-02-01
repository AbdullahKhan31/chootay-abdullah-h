package com.chootay.models;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Bike {
    @Id
    @GeneratedValue
    private int bike_id;
    @Column(nullable = false, length = 50, unique=true)
    private String model;
    @Column(nullable = false)
    private double price;
    @Column(nullable = false)
    private int quantity;
    @OneToMany(mappedBy = "bike", cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private Set<Transaction> transactions;

    public Bike() {
    }

    public Bike(int bike_id, String model, double price, int quantity, Set<Transaction> transactions) {
        this.bike_id = bike_id;
        this.model = model;
        this.price = price;
        this.quantity = quantity;
        this.transactions = transactions;
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

    public Set<Transaction> getTransactions() {
        return transactions;
    }

    public void setTransactions(Set<Transaction> transactions) {
        this.transactions = transactions;
    }
}
