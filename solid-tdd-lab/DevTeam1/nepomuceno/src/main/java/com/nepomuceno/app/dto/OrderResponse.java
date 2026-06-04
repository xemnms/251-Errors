package com.nepomuceno.app.dto;

// SOLID: SRP - carries order output data only; no logic
// OOP: Immutability - all fields are final; no setters
//
// BEFORE (mutable DTO with setters):
//   private Long id;
//   public void setId(Long id) { this.id = id; }
//   ... (setters for all fields)
//
// AFTER (immutable DTO):
//   private final Long id;
//   (no setters - once built, cannot change)
//
// WHY: Response objects are read-only by nature. Making them immutable
// reflects that intent in the type system and eliminates defensive copying.
public class OrderResponse {

    // OOP: Immutability - all fields final
    private final Long id;
    private final String status;
    private final double total;
    private final String formattedTotal;

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
}
