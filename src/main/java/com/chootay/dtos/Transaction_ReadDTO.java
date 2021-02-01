package com.chootay.dtos;

import java.sql.Date;

public class Transaction_ReadDTO {
    private Long transaction_id;
    private Customer_ReadDTO customer;
    private Bike_ReadDTO bike;
    private Sparepart_ReadDTO sparepart;
    private int quantity;
    private Date transactionDate;

    public Transaction_ReadDTO() {
    }

    public Transaction_ReadDTO(Long transaction_id, Customer_ReadDTO customer, Bike_ReadDTO bike, Sparepart_ReadDTO sparepart, int quantity, Date transactionDate) {
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

    public Customer_ReadDTO getCustomer() {
        return customer;
    }

    public void setCustomer(Customer_ReadDTO customer) {
        this.customer = customer;
    }

    public Bike_ReadDTO getBike() {
        return bike;
    }

    public void setBike(Bike_ReadDTO bike) {
        this.bike = bike;
    }

    public Sparepart_ReadDTO getSparepart() {
        return sparepart;
    }

    public void setSparepart(Sparepart_ReadDTO sparepart) {
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
