package com.nepomuceno.app.dto;

// DTO: Decouples API output from the entity layer
// GRASP: Protected Variations — entity internals are hidden from the client
public class OrderResponse {

    private Long id;
    private String status;
    private double total;
    private String formattedTotal;

    public OrderResponse() {}

    public OrderResponse(Long id, String status, double total, String formattedTotal) {
        this.id = id;
        this.status = status;
        this.total = total;
        this.formattedTotal = formattedTotal;
    }

    public Long getId() { return id; }
    public String getStatus() { return status; }
    public double getTotal() { return total; }
    public String getFormattedTotal() { return formattedTotal; }

    public void setId(Long id) { this.id = id; }
    public void setStatus(String status) { this.status = status; }
    public void setTotal(double total) { this.total = total; }
    public void setFormattedTotal(String formattedTotal) { this.formattedTotal = formattedTotal; }
}
