package com.nepomuceno.app.dto;

import java.util.List;

// DTO: Decouples API input from the entity layer
// GRASP: Protected Variations — entity changes won't break the API contract
public class OrderRequest {

    private List<ItemDto> items;

    public OrderRequest() {}

    public OrderRequest(List<ItemDto> items) {
        this.items = items;
    }

    public List<ItemDto> getItems() { return items; }
    public void setItems(List<ItemDto> items) { this.items = items; }
}
