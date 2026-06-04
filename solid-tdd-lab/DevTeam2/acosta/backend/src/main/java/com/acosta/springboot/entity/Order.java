package com.acosta.springboot.entity;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

// GRASP: Information Expert
// Order owns the list of items, so it is the EXPERT on calculating total
// No other class should do this calculation
@Entity
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String customerName;
    private String status;

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<OrderItem> items = new ArrayList<>();

    //Constructors
    public Order() {}
    public Order(String customerName) {
        this.customerName = customerName;
        this.status = "PENDING";
    }

    //GRASP Information Expert: Order owns its list of items, the only class that does this calculation
    public double calculateTotal() {
        double total = 0;
        for (OrderItem item : items) {
            total += item.getSubtotal();
        }
        return total;
    }

    // GRASP Creator: Order creates and owns its OrderItems
    public void addItem(OrderItem item) {
        item.setOrder(this);
        items.add(item);
    }

    //Getters amd Setters
    public Long getId() { return id; }

    public String getCustomerName() { return customerName; }
    public void setCustomerName(String customerName) {
        this.customerName = customerName; }

    public String getStatus() { return status; }
    public void setStatus(String status) {
        this.status = status; }

    public List<OrderItem> getItems() { return items; }
    public void setItems(List<OrderItem> items) {
        this.items = items; }
}
