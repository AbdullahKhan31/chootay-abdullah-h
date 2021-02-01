package com.chootay.models;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Sparepart {
    @Id
    @GeneratedValue
    private int sparepart_id;
    @Column(nullable = false, length = 50)
    private String item;
    @Column(nullable = false)
    private double price;
    @Column(nullable = false)
    private int quantity;
    @OneToMany(mappedBy = "sparepart", cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private Set<Transaction> transactions;

    public Sparepart() {
    }

    public Sparepart(int sparepart_id, String item, double price, int quantity, Set<Transaction> transactions) {
        this.sparepart_id = sparepart_id;
        this.item = item;
        this.price = price;
        this.quantity = quantity;
        this.transactions = transactions;
    }

    public int getSparepart_id() {
        return sparepart_id;
    }

    public void setSparepart_id(int sparepart_id) {
        this.sparepart_id = sparepart_id;
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
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
