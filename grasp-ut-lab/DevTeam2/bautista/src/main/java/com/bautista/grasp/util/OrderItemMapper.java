package com.bautista.grasp.util;

import com.bautista.grasp.dto.OrderItemDTO;
import com.bautista.grasp.entity.OrderItem;
import com.bautista.grasp.entity.Product;

public class OrderItemMapper {

    /*
     * Utility class used to convert DTO → Entity
     * GRASP: Indirection (decouples mapping logic from service layer)
     */
    public static OrderItem toEntity(OrderItemDTO dto, Product product) {

        return new OrderItem(product, dto.getQuantity());
    }
}