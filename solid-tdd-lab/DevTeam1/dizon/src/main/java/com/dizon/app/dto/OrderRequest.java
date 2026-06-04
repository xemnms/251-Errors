package com.dizon.app.dto;

import java.util.List;

// OOP: IMMUTABILITY - immutable record. The compact constructor takes a DEFENSIVE COPY
// of the incoming list (List.copyOf) so callers cannot mutate the request's internals
// after construction, and items() returns an unmodifiable list. This is true immutability,
// not just "no setters". Validated in ImmutabilityTest.
public record OrderRequest(String customerName, List<OrderItemRequest> items) {

    public OrderRequest {
        // Defensive copy → unmodifiable. Null is tolerated and normalised to an empty list
        // so downstream code never has to null-check (KISS).
        items = (items == null) ? List.of() : List.copyOf(items);
    }
}
