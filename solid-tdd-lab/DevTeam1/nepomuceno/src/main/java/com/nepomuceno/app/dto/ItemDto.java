package com.nepomuceno.app.dto;

// DTO: Carries item data from the client to the service layer
public class ItemDto {

    private String name;
    private double price;
    private int quantity;

    public ItemDto() {}

    public ItemDto(String name, double price, int quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    public String getName() { return name; }
    public double getPrice() { return price; }
    public int getQuantity() { return quantity; }

    public void setName(String name) { this.name = name; }
    public void setPrice(double price) { this.price = price; }
    public void setQuantity(int quantity) { this.quantity = quantity; }
}
