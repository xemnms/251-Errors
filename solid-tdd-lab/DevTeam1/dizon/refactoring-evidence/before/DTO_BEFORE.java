// ===== BEFORE (GRASP lab) — mutable DTO =====
// SMELL: public setters mean the object's state can be changed any time after creation.
// The items list is also assigned AFTER construction, so the object is never "complete".
package com.app.dto;

public class OrderResponse {
    private Long id;
    private String customerName;
    private OrderStatus status;
    private double total;
    private LocalDateTime createdAt;
    private List<OrderItemRequest> items;

    public OrderResponse() {}                       // ❌ empty object, then mutated piecemeal

    public OrderResponse(Long id, String customerName, OrderStatus status,
                         double total, LocalDateTime createdAt) { ... }

    // ❌ every field is mutable
    public void setId(Long id) { this.id = id; }
    public void setCustomerName(String customerName) { this.customerName = customerName; }
    public void setStatus(OrderStatus status) { this.status = status; }
    public void setTotal(double total) { this.total = total; }
    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }
    public void setItems(List<OrderItemRequest> items) { this.items = items; }   // ❌ set later
    // ... getters ...
}
