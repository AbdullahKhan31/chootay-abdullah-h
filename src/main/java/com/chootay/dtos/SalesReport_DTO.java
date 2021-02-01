package com.chootay.dtos;

import java.sql.Date;

public class SalesReport_DTO {
    private int TransactionId;
    private String Customer;
    private String Item;
    private double UnitPrice;
    private int Quantity;
    private double TotalPrice;
    private Date TransactionDate;

    public SalesReport_DTO() {
    }

    public SalesReport_DTO(int transactionId, String customer, String item, double unitPrice, int quantity, double totalPrice, Date transactionDate) {
        TransactionId = transactionId;
        Customer = customer;
        Item = item;
        UnitPrice = unitPrice;
        Quantity = quantity;
        TotalPrice = totalPrice;
        TransactionDate = transactionDate;
    }

    public int getTransactionId() {
        return TransactionId;
    }

    public void setTransactionId(int transactionId) {
        TransactionId = transactionId;
    }

    public String getCustomer() {
        return Customer;
    }

    public void setCustomer(String customer) {
        Customer = customer;
    }

    public String getItem() {
        return Item;
    }

    public void setItem(String item) {
        Item = item;
    }

    public double getUnitPrice() {
        return UnitPrice;
    }

    public void setUnitPrice(double unitPrice) {
        UnitPrice = unitPrice;
    }

    public int getQuantity() {
        return Quantity;
    }

    public void setQuantity(int quantity) {
        Quantity = quantity;
    }

    public double getTotalPrice() {
        return TotalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        TotalPrice = totalPrice;
    }

    public Date getTransactionDate() {
        return TransactionDate;
    }

    public void setTransactionDate(Date transactionDate) {
        TransactionDate = transactionDate;
    }
}
