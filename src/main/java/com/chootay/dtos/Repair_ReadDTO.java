package com.chootay.dtos;

import java.sql.Date;

public class Repair_ReadDTO {
    private int repair_id;
    private int customer_id;
    private String customerName;
    private double cost;
    private String description;
    private Date repairDate;

    public Repair_ReadDTO() {
    }

    public Repair_ReadDTO(int repair_id, int customer_id, String customerName, double cost, String description, Date repairDate) {
        this.repair_id = repair_id;
        this.customer_id = customer_id;
        this.customerName = customerName;
        this.cost = cost;
        this.description = description;
        this.repairDate = repairDate;
    }

    public int getRepair_id() {
        return repair_id;
    }

    public void setRepair_id(int repair_id) {
        this.repair_id = repair_id;
    }

    public int getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(int customer_id) {
        this.customer_id = customer_id;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
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
