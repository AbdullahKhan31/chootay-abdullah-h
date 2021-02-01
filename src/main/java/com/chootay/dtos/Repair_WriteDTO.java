package com.chootay.dtos;

import java.sql.Date;

public class Repair_WriteDTO {
    private Customer_ReadDTO customer;
    private double cost;
    private String description;
    private Date repairDate;

    public Repair_WriteDTO() {
    }

    public Repair_WriteDTO(Customer_ReadDTO customer, double cost, String description, Date repairDate) {
        this.customer = customer;
        this.cost = cost;
        this.description = description;
        this.repairDate = repairDate;
    }

    public Customer_ReadDTO getCustomer() {
        return customer;
    }

    public void setCustomer(Customer_ReadDTO customer) {
        this.customer = customer;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getRepairDate() {
        return repairDate;
    }

    public void setRepairDate(Date repairDate) {
        this.repairDate = repairDate;
    }
}
