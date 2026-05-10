package com.bautista.grasp.service;

import com.bautista.grasp.dto.*;
import com.bautista.grasp.entity.*;
import com.bautista.grasp.exception.OrderNotFoundException;
import com.bautista.grasp.exception.ProductNotFoundException;
import com.bautista.grasp.repository.OrderRepository;
import com.bautista.grasp.repository.ProductRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class OrderServiceTest {

    @Mock
    OrderRepository orderRepository;

    @Mock
    ProductRepository productRepository;

    @InjectMocks
    OrderServiceImpl service;

    @Test
    void shouldCreateOrderSuccessfully() {

        Product product = new Product(1L, "Laptop", 1000);

        when(productRepository.findById(1L))
                .thenReturn(Optional.of(product));

        when(orderRepository.save(any()))
                .thenAnswer(i -> i.getArgument(0));

        OrderItemDTO itemDTO = new OrderItemDTO(1L, 2);

        OrderRequestDTO request = new OrderRequestDTO(List.of(itemDTO));

        OrderResponseDTO response = service.createOrder(request);

        assertEquals(2000, response.getTotalAmount());
    }

    @Test
    void shouldThrowWhenProductNotFound() {

        when(productRepository.findById(anyLong()))
                .thenReturn(Optional.empty());

        OrderItemDTO itemDTO = new OrderItemDTO(99L, 1);

        OrderRequestDTO request = new OrderRequestDTO(List.of(itemDTO));

        assertThrows(ProductNotFoundException.class,
                () -> service.createOrder(request));
    }

    @Test
    void shouldReturnOrderTotal() {

        Order order = mock(Order.class);

        when(order.calculateTotal()).thenReturn(1500.0);
        when(orderRepository.findById(1L)).thenReturn(Optional.of(order));

        double total = service.getOrderTotal(1L);

        assertEquals(1500.0, total);
    }

    @Test
    void shouldThrowWhenOrderNotFound() {

        when(orderRepository.findById(anyLong()))
                .thenReturn(Optional.empty());

        assertThrows(OrderNotFoundException.class,
                () -> service.getOrderTotal(1L));
    }

    @Test
    void shouldProcessCardPayment() {

        Order order = mock(Order.class);
        when(order.calculateTotal()).thenReturn(1000.0);

        when(orderRepository.findById(1L))
                .thenReturn(Optional.of(order));

        String result = service.processPayment(1L, "CARD");

        assertTrue(result.contains("CARD"));
        assertTrue(result.contains("1000"));
    }
}