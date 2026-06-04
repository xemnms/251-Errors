package com.nepomuceno.app.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Collections;
import java.util.List;

// SOLID: SRP - carries order input data only; no logic
// OOP: Immutability - fields are final; list is wrapped in unmodifiableList
//
// BEFORE (mutable DTO with setters):
//   private List<ItemDto> items;
//   public void setItems(List<ItemDto> items) { this.items = items; }
//
// AFTER (immutable DTO):
//   private final List<ItemDto> items;
//   getter returns unmodifiable view
//
// WHY: An immutable request object prevents any layer from silently
// modifying the input after it has been validated.
public final class OrderRequest {

    private final List<ItemDto> items;

    @JsonCreator
    public OrderRequest(@JsonProperty("items") List<ItemDto> items) {
        // Immutability: wrap in unmodifiableList so no caller can mutate the list
        // null guard deferred to OrderValidator — SRP: validation is not a DTO concern
        this.items = items == null ? null : Collections.unmodifiableList(items);
    }

    public List<ItemDto> getItems() {
        return items; // already unmodifiable — safe to return directly
    }
}
