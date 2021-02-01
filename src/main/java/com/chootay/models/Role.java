package com.chootay.models;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Role {
    @Id
    @GeneratedValue
    private int role_id;
    @Column(nullable = false, length=30)
    private String role;

    public Role() {
    }

    public Role(int role_id, String role) {
        this.role_id = role_id;
        this.role = role;
    }

    public int getRole_id() {
        return role_id;
    }

    public void setRole_id(int role_id) {
        this.role_id = role_id;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

}
