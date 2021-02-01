package com.chootay.models;

import javax.persistence.*;
import java.sql.Date;

@Entity
public class Transaction {
    @Id
    @GeneratedValue
    private Long transaction_id;

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(name = "customer_id")
    private Customer customer;

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(name = "bike_id")
    private Bike bike;

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(name = "sparepart_id")
    private Sparepart sparepart;

    @Column(nullable = false)
    private int quantity;
    private Date transactionDate;

    public Transaction() {
    }

    public Transaction(Long transaction_id, Customer customer, Bike bike, Sparepart sparepart, int quantity, Date transactionDate) {
        this.transaction_id = transaction_id;
        this.customer = customer;
        this.bike = bike;
        this.sparepart = sparepart;
        this.quantity = quantity;
        this.transactionDate = transactionDate;
    }

    public Long getTransaction_id() {
        return transaction_id;
    }

    public void setTransaction_id(Long transaction_id) {
        this.transaction_id = transaction_id;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Bike getBike() {
        return bike;
    }

    public void setBike(Bike bike) {
        this.bike = bike;
    }

    public Sparepart getSparepart() {
        return sparepart;
    }

    public void setSparepart(Sparepart sparepart) {
        this.sparepart = sparepart;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Date getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(Date transactionDate) {
        this.transactionDate = transactionDate;
    }
}
