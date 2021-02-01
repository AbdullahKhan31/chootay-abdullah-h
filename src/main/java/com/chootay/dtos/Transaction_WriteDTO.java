package com.chootay.dtos;

import com.chootay.models.Bike;
import com.chootay.models.Customer;
import com.chootay.models.Sparepart;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.sql.Date;

public class Transaction_WriteDTO {
    private Customer_ReadDTO customer;
    private int bike_id;
    private int sparepart_id;
    private int quantity;
    private Date transactionDate;

    public Transaction_WriteDTO() {
    }

    public Transaction_WriteDTO(Customer_ReadDTO customer, int bike_id, int sparepart_id, int quantity, Date transactionDate) {
        this.customer = customer;
        this.bike_id = bike_id;
        this.sparepart_id = sparepart_id;
        this.quantity = quantity;
        this.transactionDate = transactionDate;
    }

    public Customer_ReadDTO getCustomer() {
        return customer;
    }

    public void setCustomer(Customer_ReadDTO customer) {
        this.customer = customer;
    }

    public int getBike_id() {
        return bike_id;
    }

    public void setBike_id(int bike_id) {
        this.bike_id = bike_id;
    }

    public int getSparepart_id() {
        return sparepart_id;
    }

    public void setSparepart_id(int sparepart_id) {
        this.sparepart_id = sparepart_id;
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
