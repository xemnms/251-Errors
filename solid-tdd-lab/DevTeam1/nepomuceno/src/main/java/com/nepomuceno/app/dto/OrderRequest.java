package com.nepomuceno.app.dto;

import java.util.Collections;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

// SOLID: SRP - carries order input data only; no logic
// OOP: Immutability - fields are final; list is wrapped in unmodifiableList
//
// BEFORE (mutable DTO):
//   private List<ItemDto> items;
//   public void setItems(List<ItemDto> items) { this.items = items; }
//
// AFTER (immutable DTO):
//   private final List<ItemDto> items;
//   getter returns unmodifiable view
//
// WHY: An immutable request object prevents any layer from silently
// modifying the input after it has been validated.
public class OrderRequest {

    private final List<ItemDto> items;

    // Jackson needs this to deserialize JSON in controller tests
    @JsonCreator
    public OrderRequest(@JsonProperty("items") List<ItemDto> items) {
        this.items = items;
    }

    public List<ItemDto> getItems() { return items; }
}