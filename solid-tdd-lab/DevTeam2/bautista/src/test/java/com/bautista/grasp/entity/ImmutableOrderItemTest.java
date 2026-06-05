package com.bautista.grasp.entity;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

// Immutability validation: confirms the record has no mutation capabilities
class ImmutableOrderItemTest {

    @Test
    void shouldCalculateSubtotalCorrectly() {

        ImmutableOrderItem item = new ImmutableOrderItem(1L, "Laptop", 1000.0, 2);

        assertEquals(2000.0, item.calculateSubtotal());
    }

    @Test
    void shouldPreserveAllFieldsAfterConstruction() {

        ImmutableOrderItem item = new ImmutableOrderItem(1L, "Tablet", 300.0, 3);

        assertEquals(1L, item.productId());
        assertEquals("Tablet", item.productName());
        assertEquals(300.0, item.price());
        assertEquals(3, item.quantity());
    }

    @Test
    void shouldHaveNoSetterMethods() {

        // Immutability: records never generate setters - this confirms by reflection
        boolean hasSetters = Arrays.stream(ImmutableOrderItem.class.getMethods())
                .anyMatch(m -> m.getName().startsWith("set"));

        assertFalse(hasSetters, "Immutable record should not expose any setter methods");
    }

    @Test
    void shouldThrowForNonPositiveQuantity() {

        assertThrows(IllegalArgumentException.class,
                () -> new ImmutableOrderItem(1L, "Item", 100.0, 0));
    }

    @Test
    void shouldThrowForNegativePrice() {

        assertThrows(IllegalArgumentException.class,
                () -> new ImmutableOrderItem(1L, "Item", -10.0, 1));
    }

    @Test
    void shouldThrowForBlankProductName() {

        assertThrows(IllegalArgumentException.class,
                () -> new ImmutableOrderItem(1L, "  ", 50.0, 1));
    }
}
