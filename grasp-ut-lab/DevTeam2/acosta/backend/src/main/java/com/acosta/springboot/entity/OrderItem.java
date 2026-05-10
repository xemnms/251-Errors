package com.acosta.springboot.entity;

import jakarta.persistence.*;

// GRASP: Information Expert - OrderItem knows its own price and quantity
@Entity
@Table(name = "order_items")
public class OrderItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String productName;
    private double price;
    private int quantity;


    @JoinColumn(name = "order_id")
    private Order order;

    //Constructors
    public OrderItem() {}
    public OrderItem(String productName, double price, int quantity) {
        this.productName = productName;
        this.price = price;
        this.quantity = quantity;
    }

    //Getters and Setters
    public Long getId() { return id; }

    public String getProductName() { return productName; }

    public void setProductName(String productName) {
        this.productName = productName; }

    public double getPrice() { return price; }
    public void setPrice(double price) {
        this.price = price; }

    public int getQuantity() { return quantity; }
    public void setQuantity(int quantity) {
        this.quantity = quantity; }

    public Order getOrder() { return order; }
    public void setOrder(Order order) {
        this.order = order; }

    public double getSubtotal() {
        return price * quantity;
    }
}