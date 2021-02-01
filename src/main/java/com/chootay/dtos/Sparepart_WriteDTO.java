package com.chootay.dtos;

public class Sparepart_WriteDTO {
    private String item;
    private double price;
    private int quantity;

    public Sparepart_WriteDTO() {
    }

    public Sparepart_WriteDTO(String item, double price, int quantity) {
        this.item = item;
        this.price = price;
        this.quantity = quantity;
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
