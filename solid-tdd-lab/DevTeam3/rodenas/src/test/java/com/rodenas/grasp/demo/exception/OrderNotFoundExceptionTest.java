package com.rodenas.grasp.demo.exception;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OrderNotFoundExceptionTest {

    @Test
    void shouldIncludeIdInMessage() {
        OrderNotFoundException ex = new OrderNotFoundException(55L);

        assertTrue(ex.getMessage().contains("55"));
    }
}
