package com.dizon.app.dto;

import com.dizon.app.entity.OrderStatus;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * IMMUTABILITY VALIDATION: proves the DTO records cannot be modified after construction
 * and preserve consistent state even when the caller mutates the inputs they passed in.
 */
class ImmutabilityTest {

    @Test
    void orderRequest_defensivelyCopiesItems_soLaterMutationsDoNotLeakIn() {
        List<OrderItemRequest> mutable = new ArrayList<>();
        mutable.add(new OrderItemRequest("Laptop", 999.99, 1));

        OrderRequest request = new OrderRequest("Vic Andrew Dizon", mutable);

        // Mutate the ORIGINAL list after constructing the record.
        mutable.add(new OrderItemRequest("Hacked", 0.0, 99));

        // The record's state is unaffected -> it took a defensive copy.
        assertEquals(1, request.items().size());
    }

    @Test
    void orderRequest_itemsList_isUnmodifiable() {
        OrderRequest request = new OrderRequest("Vic Andrew Dizon",
                List.of(new OrderItemRequest("Laptop", 999.99, 1)));

        assertThrows(UnsupportedOperationException.class,
                () -> request.items().add(new OrderItemRequest("X", 1.0, 1)));
    }

    @Test
    void orderResponse_itemsList_isUnmodifiable() {
        OrderResponse response = new OrderResponse(1L, "Vic Andrew Dizon",
                OrderStatus.PENDING, 100.0, LocalDateTime.now(),
                List.of(new OrderItemRequest("Laptop", 100.0, 1)));

        assertThrows(UnsupportedOperationException.class,
                () -> response.items().clear());
    }

    @Test
    void records_preserveConsistentState_viaAccessors() {
        OrderItemRequest item = new OrderItemRequest("Phone", 500.0, 2);

        // Accessors always return the same values - no setters exist to change them.
        assertEquals("Phone", item.productName());
        assertEquals(500.0, item.price());
        assertEquals(2, item.quantity());
    }

    @Test
    void orderRequest_normalisesNullItemsToEmptyList() {
        OrderRequest request = new OrderRequest("Vic Andrew Dizon", null);

        assertNotNull(request.items());
        assertTrue(request.items().isEmpty());
    }
}
