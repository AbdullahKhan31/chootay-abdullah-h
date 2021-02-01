package com.chootay.dtos;

import javax.persistence.Column;

public class Sparepart_ReadDTO {
    private int sparepart_id;
    private String item;
    private double price;
    private int quantity;

    public Sparepart_ReadDTO() {
    }

    public Sparepart_ReadDTO(int sparepart_id, String item, double price, int quantity) {
        this.sparepart_id = sparepart_id;
        this.item = item;
        this.price = price;
        this.quantity = quantity;
    }

    public int getSparepart_id() {
        return sparepart_id;
    }

    public void setSparepart_id(int sparepart_id) {
        this.sparepart_id = sparepart_id;
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
