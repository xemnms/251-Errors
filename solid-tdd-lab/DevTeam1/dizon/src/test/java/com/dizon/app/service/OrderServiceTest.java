package com.dizon.app.service;

import com.dizon.app.dto.OrderItemRequest;
import com.dizon.app.dto.OrderRequest;
import com.dizon.app.dto.OrderResponse;
import com.dizon.app.entity.Order;
import com.dizon.app.entity.OrderStatus;
import com.dizon.app.exception.InvalidOrderException;
import com.dizon.app.exception.OrderNotFoundException;
import com.dizon.app.mapper.OrderMapper;
import com.dizon.app.repository.OrderRepository;
import com.dizon.app.validator.OrderValidator;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InOrder;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

/**
 * Service-layer tests.
 *
 * SOLID DIP PROOF: every collaborator here is a MOCKED INTERFACE
 * (OrderRepository, OrderValidator, OrderMapper). Because OrderService depends only on
 * abstractions, it can be fully exercised with zero concrete classes and no database.
 * This is the direct payoff of the Dependency Inversion refactor.
 */
@ExtendWith(MockitoExtension.class)
class OrderServiceTest {

    @Mock private OrderRepository orderRepository;
    @Mock private OrderValidator orderValidator;   // DIP: mock the abstraction, not OrderValidatorImpl
    @Mock private OrderMapper orderMapper;          // DIP: mock the abstraction, not OrderMapperImpl

    @InjectMocks private OrderService orderService;

    private OrderResponse stubResponse(Long id, String name, double total) {
        return new OrderResponse(id, name, OrderStatus.PENDING, total, LocalDateTime.now(), List.of());
    }

    // 1. Happy path: validates, saves, maps. Verifies interactions (Mockito requirement).
    @Test
    void shouldCreateOrder_validatingSavingAndMapping() {
        OrderRequest request = new OrderRequest("Vic Andrew Dizon",
                List.of(new OrderItemRequest("Laptop", 999.99, 1)));
        Order saved = new Order("Vic Andrew Dizon");
        saved.setId(1L);

        when(orderRepository.save(any(Order.class))).thenReturn(saved);
        when(orderMapper.toResponse(saved)).thenReturn(stubResponse(1L, "Vic Andrew Dizon", 999.99));

        OrderResponse response = orderService.createOrder(request);

        assertNotNull(response);
        assertEquals("Vic Andrew Dizon", response.customerName());
        // Verify interactions / ordering across the mocked collaborators.
        InOrder inOrder = inOrder(orderValidator, orderRepository, orderMapper);
        inOrder.verify(orderValidator).validate(request);
        inOrder.verify(orderRepository).save(any(Order.class));
        inOrder.verify(orderMapper).toResponse(saved);
    }

    // 2. DIP proof: when the mocked validator rejects the request, the service must abort
    //    BEFORE touching the repository. We control behaviour purely through the interface mock.
    @Test
    void shouldNotSave_whenValidatorRejectsRequest() {
        OrderRequest request = new OrderRequest("", List.of());
        doThrow(new InvalidOrderException("Customer name must not be empty"))
                .when(orderValidator).validate(request);

        assertThrows(InvalidOrderException.class, () -> orderService.createOrder(request));
        verify(orderRepository, never()).save(any());
        verify(orderMapper, never()).toResponse(any());
    }

    // 3. Get all orders.
    @Test
    void shouldGetAllOrders() {
        Order o1 = new Order("A"); o1.setId(1L);
        Order o2 = new Order("B"); o2.setId(2L);
        when(orderRepository.findAll()).thenReturn(List.of(o1, o2));
        when(orderMapper.toResponse(any(Order.class))).thenReturn(stubResponse(1L, "A", 0));

        List<OrderResponse> result = orderService.getAllOrders();

        assertEquals(2, result.size());
        verify(orderRepository).findAll();
    }

    // 4. Edge case: empty collection.
    @Test
    void shouldReturnEmptyList_whenNoOrders() {
        when(orderRepository.findAll()).thenReturn(Collections.emptyList());

        assertTrue(orderService.getAllOrders().isEmpty());
        verify(orderMapper, never()).toResponse(any());
    }

    // 5. Get by id.
    @Test
    void shouldGetOrderById() {
        Order order = new Order("Vic Andrew Dizon"); order.setId(1L);
        when(orderRepository.findById(1L)).thenReturn(Optional.of(order));
        when(orderMapper.toResponse(order)).thenReturn(stubResponse(1L, "Vic Andrew Dizon", 500));

        OrderResponse response = orderService.getOrderById(1L);

        assertEquals("Vic Andrew Dizon", response.customerName());
    }

    // 6. Edge case: missing record -> custom exception.
    @Test
    void shouldThrow_whenOrderByIdNotFound() {
        when(orderRepository.findById(99L)).thenReturn(Optional.empty());

        assertThrows(OrderNotFoundException.class, () -> orderService.getOrderById(99L));
    }

    // 7. Update status.
    @Test
    void shouldUpdateOrderStatus() {
        Order order = new Order("Vic Andrew Dizon"); order.setId(1L);
        when(orderRepository.findById(1L)).thenReturn(Optional.of(order));
        when(orderRepository.save(order)).thenReturn(order);
        when(orderMapper.toResponse(order)).thenReturn(stubResponse(1L, "Vic Andrew Dizon", 0));

        orderService.updateOrderStatus(1L, "shipped");

        assertEquals(OrderStatus.SHIPPED, order.getStatus());   // case-insensitive parse
        verify(orderRepository).save(order);
    }

    // 8. Delete.
    @Test
    void shouldDeleteOrder() {
        when(orderRepository.existsById(1L)).thenReturn(true);

        orderService.deleteOrder(1L);

        verify(orderRepository).deleteById(1L);
    }

    // 9. Edge case: delete missing record.
    @Test
    void shouldThrow_whenDeletingNonExistentOrder() {
        when(orderRepository.existsById(99L)).thenReturn(false);

        assertThrows(OrderNotFoundException.class, () -> orderService.deleteOrder(99L));
        verify(orderRepository, never()).deleteById(any());
    }

    // 10. Edge case: order with no items is allowed (validator passes empty list).
    @Test
    void shouldCreateOrder_withNoItems() {
        OrderRequest request = new OrderRequest("Vic Andrew Dizon", List.of());
        Order saved = new Order("Vic Andrew Dizon"); saved.setId(1L);
        when(orderRepository.save(any(Order.class))).thenReturn(saved);
        when(orderMapper.toResponse(saved)).thenReturn(stubResponse(1L, "Vic Andrew Dizon", 0.0));

        OrderResponse response = orderService.createOrder(request);

        assertEquals(0.0, response.total());
        verify(orderValidator).validate(request);
    }
}
