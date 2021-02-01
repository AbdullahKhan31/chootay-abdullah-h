package com.chootay.dtos;

import javax.persistence.Column;

public class Customer_ReadDTO {
    private int customer_id;
    private String name;
    private String email;

    public Customer_ReadDTO() {
    }

    public Customer_ReadDTO(int customer_id, String name, String email) {
        this.customer_id = customer_id;
        this.name = name;
        this.email = email;
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
}
