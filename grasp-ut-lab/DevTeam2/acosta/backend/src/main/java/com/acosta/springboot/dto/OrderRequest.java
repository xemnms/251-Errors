package com.acosta.springboot.dto;
import java.util.List;


public class OrderRequest {

    //Attributes
    private String customerName;
    private List<OrderItemRequest> items;
    private String paymentMethod;


    //Constructors
    public OrderRequest() {}
    public OrderRequest(String customerName, List<OrderItemRequest> items, String paymentMethod) {
        this.customerName = customerName;
        this.items = items;
        this.paymentMethod = paymentMethod;
    }

    //Getters and Setters
    public String getCustomerName() { return customerName; }
    public void setCustomerName(String customerName) { this.customerName = customerName; }

    public List<OrderItemRequest> getItems() { return items; }
    public void setItems(List<OrderItemRequest> items) { this.items = items; }

    public String getPaymentMethod() { return paymentMethod; }
    public void setPaymentMethod(String paymentMethod) { this.paymentMethod = paymentMethod; }

    //Inner Class
    public static class OrderItemRequest {
        private String productName;
        private double price;
        private int quantity;

        public OrderItemRequest() {}

        public OrderItemRequest(String productName, double price, int quantity) {
            this.productName = productName;
            this.price = price;
            this.quantity = quantity;
        }

        public String getProductName() { return productName; }
        public void setProductName(String productName) { this.productName = productName; }

        public double getPrice() { return price; }
        public void setPrice(double price) { this.price = price; }

        public int getQuantity() { return quantity; }
        public void setQuantity(int quantity) { this.quantity = quantity; }
    }
}