package com.bautista.grasp.util;

import com.bautista.grasp.dto.OrderItemDTO;
import com.bautista.grasp.entity.OrderItem;
import com.bautista.grasp.entity.Product;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OrderItemMapperTest {

    /*
     * Tests GRASP: Indirection (mapping layer correctness)
     */
    @Test
    void shouldMapDtoToEntityCorrectly() {

        Product product = new Product(1L, "Laptop", 1000.0);

        OrderItemDTO dto = new OrderItemDTO(1L, 2);

        OrderItem item = OrderItemMapper.toEntity(dto, product);

        assertEquals(2, item.getQuantity());
        assertEquals(product, item.getProduct());
    }
}