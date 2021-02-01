package com.chootay.models;

import javax.persistence.*;
import java.sql.Date;

@Entity
public class Repair {
    @Id
    @GeneratedValue
    private int repair_id;

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(name = "customer_id")
    private Customer customer;
    @Column(nullable = false)
    private double cost;
    @Column(nullable = true)
    private String description;
    private Date repairDate;

    public Repair() {
    }

    public Repair(int repair_id, Customer customer, double cost, String description, Date repairDate) {
        this.repair_id = repair_id;
        this.customer = customer;
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

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
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
