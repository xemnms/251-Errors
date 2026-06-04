package com.dizon.app.mapper;

import com.dizon.app.dto.OrderResponse;
import com.dizon.app.entity.Order;
import com.dizon.app.entity.OrderItem;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit tests for the extracted mapping logic (SRP). Confirms the mapper delegates the
 * total to the Order entity (Information Expert preserved) and copies items correctly.
 */
class OrderMapperTest {

    private final OrderMapper mapper = new OrderMapperImpl();

    @Test
    void shouldMapOrderToResponse_withCorrectTotalAndItems() {
        Order order = new Order("Vic Andrew Dizon");
        order.setId(1L);
        order.addItem(new OrderItem("Phone", 500.00, 2));   // subtotal 1000
        order.addItem(new OrderItem("Case", 25.50, 1));     // subtotal 25.50

        OrderResponse response = mapper.toResponse(order);

        assertEquals(1L, response.id());
        assertEquals("Vic Andrew Dizon", response.customerName());
        assertEquals(1025.50, response.total());            // Information Expert: total from Order
        assertEquals(2, response.items().size());
    }

    @Test
    void shouldMapOrder_withNoItems() {
        Order order = new Order("Vic Andrew Dizon");
        order.setId(2L);

        OrderResponse response = mapper.toResponse(order);

        assertEquals(0.0, response.total());
        assertTrue(response.items().isEmpty());
    }
}
