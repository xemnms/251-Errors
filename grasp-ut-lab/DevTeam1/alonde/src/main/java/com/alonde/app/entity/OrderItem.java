package com.alonde.app.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;

@Entity
@Table(name = "order_items")
public class OrderItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Product name is required")
    private String productName;

    @Positive(message = "Quantity must be positive")
    private int quantity;

    @DecimalMin(value = "0.0", inclusive = false, message = "Price must be positive")
    private Double unitPrice;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "order_id")
    private Order order;

    public OrderItem() {}
    public OrderItem(String productName, int quantity, Double unitPrice) {
        this.productName = productName;
        this.quantity    = quantity;
        this.unitPrice   = unitPrice;
    }

    // getters and setters
    public Long getId()               { return id; }
    public String getProductName()    { return productName; }
    public void setProductName(String n) { this.productName = n; }
    public int getQuantity()          { return quantity; }
    public void setQuantity(int q)   { this.quantity = q; }
    public Double getUnitPrice()      { return unitPrice; }
    public void setUnitPrice(Double p){ this.unitPrice = p; }
    public void setOrder(Order o)     { this.order = o; }
}
