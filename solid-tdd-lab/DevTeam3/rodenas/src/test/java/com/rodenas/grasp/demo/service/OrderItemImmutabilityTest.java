package com.rodenas.grasp.demo.service;

import com.rodenas.grasp.demo.dto.OrderItemDTO;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Method;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class OrderItemImmutabilityTest {

    @Test
    void orderItemDTOShouldBeImmutable() {
        OrderItemDTO item = new OrderItemDTO("Burger", 120.0, 2);

        assertEquals("Burger", item.menuItemName());
        assertEquals(120.0, item.price());
        assertEquals(2, item.quantity());

        Method[] methods = OrderItemDTO.class.getDeclaredMethods();
        boolean hasSetters = Arrays.stream(methods)
                .anyMatch(method -> method.getName().startsWith("set"));

        assertFalse(hasSetters, "Record-based DTO should not expose setters");
    }
}
