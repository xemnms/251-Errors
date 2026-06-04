// ===== AFTER (SOLID refactor) — immutable record =====
// FIX: a record is implicitly final with final fields and no setters. The compact
// constructor takes a DEFENSIVE COPY of the list, so the object is fully built in one
// shot and can never change afterwards. Verified in ImmutabilityTest.
package com.dizon.app.dto;

public record OrderResponse(
        Long id,
        String customerName,
        OrderStatus status,
        double total,
        LocalDateTime createdAt,
        List<OrderItemRequest> items
) {
    public OrderResponse {
        items = (items == null) ? List.of() : List.copyOf(items);   // ✅ defensive, unmodifiable
    }
}

// And the request DTOs, also immutable records:
//   public record OrderItemRequest(String productName, double price, int quantity) {}
//   public record OrderRequest(String customerName, List<OrderItemRequest> items) {
//       public OrderRequest { items = (items == null) ? List.of() : List.copyOf(items); }
//   }
