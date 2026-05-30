package com.acosta.springboot.service;

import com.acosta.springboot.entity.OrderItem;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

// SOLID: SRP  - This test class only tests OrderItem immutability
// OOP: Immutability - verifies state cannot change after construction
class OrderItemImmutabilityTest {

    // =========================================================
    // TEST 1: Values set at construction are preserved
    // =========================================================
    @Test
    void shouldPreserveValuesAfterConstruction() {
        // Immutability: all values locked at creation time
        OrderItem item = new OrderItem("Burger", 99.0, 2);

        assertEquals("Burger", item.getProductName());
        assertEquals(99.0, item.getPrice());
        assertEquals(2, item.getQuantity());
    }

    // =========================================================
    // TEST 2: Subtotal is always consistent with construction values
    // =========================================================
    @Test
    void shouldCalculateConsistentSubtotal() {
        OrderItem item = new OrderItem("Pizza", 150.0, 3);

        // Immutability: subtotal always reflects original price x quantity
        double expectedSubtotal = 150.0 * 3;
        assertEquals(expectedSubtotal, item.getSubtotal());

        // Calling it twice should return the same value — no state drift
        assertEquals(item.getSubtotal(), item.getSubtotal());
    }

    // =========================================================
    // TEST 3: Two items with same values should have same subtotal
    // =========================================================
    @Test
    void shouldProduceSameSubtotalForSameInputs() {
        OrderItem item1 = new OrderItem("Fries", 50.0, 4);
        OrderItem item2 = new OrderItem("Fries", 50.0, 4);

        // Immutability: same construction = same consistent state
        assertEquals(item1.getSubtotal(), item2.getSubtotal());
        assertEquals(item1.getProductName(), item2.getProductName());
    }

    // =========================================================
    // TEST 4: Edge case — zero quantity should give zero subtotal
    // =========================================================
    @Test
    void shouldReturnZeroSubtotalForZeroQuantity() {
        OrderItem item = new OrderItem("Drink", 30.0, 0);
        assertEquals(0.0, item.getSubtotal());
    }

    // =========================================================
    // TEST 5: Edge case — null product name should throw
    // =========================================================
    @Test
    void shouldThrowWhenProductNameIsNull() {
        assertThrows(IllegalArgumentException.class, () -> {
            new OrderItem(null, 99.0, 1);
        });
    }

    // =========================================================
    // TEST 6: Edge case — negative price should throw
    // =========================================================
    @Test
    void shouldThrowWhenPriceIsNegative() {
        assertThrows(IllegalArgumentException.class, () -> {
            new OrderItem("Burger", -10.0, 1);
        });
    }
}