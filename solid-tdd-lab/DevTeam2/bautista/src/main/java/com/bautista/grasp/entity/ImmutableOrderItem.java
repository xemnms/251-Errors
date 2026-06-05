package com.bautista.grasp.entity;

// Immutability: OOP best practice for value objects - all fields are final via record
// SOLID: SRP - represents only a snapshot of an order item, no persistence or mutation
public record ImmutableOrderItem(Long productId, String productName, double price, int quantity) {

    // Compact constructor for validation
    public ImmutableOrderItem {
        if (quantity <= 0) throw new IllegalArgumentException("Quantity must be positive");
        if (price < 0) throw new IllegalArgumentException("Price cannot be negative");
        if (productName == null || productName.isBlank()) throw new IllegalArgumentException("Product name is required");
    }

    // DRY: calculation lives here, not scattered across callers
    public double calculateSubtotal() {
        return price * quantity;
    }
}
