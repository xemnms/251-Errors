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

// Note: Order is a JPA entity (final-ish on Java 25 with Mockito inline) - use real instances

@ExtendWith(MockitoExtension.class)
class OrderServiceTest {

    @Mock
    OrderRepository orderRepository;

    @Mock
    ProductRepository productRepository;

    // SRP proof: OrderValidator is mocked and injected - service delegates validation
    @Mock
    OrderValidator orderValidator;

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
    void shouldDelegateValidationToOrderValidator() {

        // SRP proof: service calls the validator, does not inline validation rules
        Product product = new Product(1L, "Laptop", 1000);
        when(productRepository.findById(1L)).thenReturn(Optional.of(product));
        when(orderRepository.save(any())).thenAnswer(i -> i.getArgument(0));

        OrderRequestDTO request = new OrderRequestDTO(List.of(new OrderItemDTO(1L, 1)));

        service.createOrder(request);

        verify(orderValidator).validate(request);
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

        // Using real Order instance - Mockito cannot inline-mock JPA entities on Java 25
        Product product = new Product(1L, "Laptop", 1500.0);
        Order order = new Order(List.of(new OrderItem(product, 1)));
        when(orderRepository.findById(1L)).thenReturn(Optional.of(order));

        double total = service.getOrderTotal(1L);

        assertEquals(1500.0, total);
    }

    @Test
    void shouldReturnZeroTotalForEmptyOrder() {

        // Edge case: order with no items should return 0, not throw
        Order order = new Order(List.of());
        when(orderRepository.findById(1L)).thenReturn(Optional.of(order));

        double total = service.getOrderTotal(1L);

        assertEquals(0.0, total);
    }

    @Test
    void shouldThrowWhenOrderNotFound() {

        when(orderRepository.findById(anyLong()))
                .thenReturn(Optional.empty());

        assertThrows(OrderNotFoundException.class,
                () -> service.getOrderTotal(1L));
    }
}