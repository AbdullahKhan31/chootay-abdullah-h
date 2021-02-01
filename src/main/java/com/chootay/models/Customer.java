package com.chootay.models;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Customer {
    @Id
    @GeneratedValue
    private int customer_id;
    @Column(nullable = false, length = 30)
    private String name;
    @Column(nullable = false, length = 30, unique=true)
    private String email;
    @OneToMany(mappedBy = "customer", cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private Set<Transaction> transactions;
    @OneToMany(mappedBy = "customer", cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private Set<Repair> repair;

    public Customer() {
    }

    public Customer(int customer_id, String name, String email, Set<Transaction> transactions, Set<Repair> repair) {
        this.customer_id = customer_id;
        this.name = name;
        this.email = email;
        this.transactions = transactions;
        this.repair = repair;
    }

    public int getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(int customer_id) {
        this.customer_id = customer_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Set<Transaction> getTransactions() {
        return transactions;
    }

    public void setTransactions(Set<Transaction> transactions) {
        this.transactions = transactions;
    }

    public Set<Repair> getRepair() {
        return repair;
    }

    public void setRepair(Set<Repair> repair) {
        this.repair = repair;
    }
}
