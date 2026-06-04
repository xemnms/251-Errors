package com.app.service;

import com.app.dto.OrderDTO;
import com.app.entity.Order;
import com.app.repository.OrderRepository;
import com.app.util.OrderNotFoundException;
import com.app.util.OrderValidator;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.List;
import java.util.Optional;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class OrderServiceTest {

    @Mock OrderRepository orderRepository;
    @Mock OrderValidator orderValidator;
    @InjectMocks OrderServiceImpl orderService;

    @Test
    void shouldCreateOrderSuccessfully() {
        OrderDTO dto = new OrderDTO("Juan", "CASH");
        when(orderValidator.isValid(dto)).thenReturn(true);
        when(orderRepository.save(any(Order.class))).thenReturn(new Order("Juan"));
        Order result = orderService.createOrder(dto);
        assertNotNull(result);
        assertEquals("Juan", result.getCustomerName());
        verify(orderRepository, times(1)).save(any(Order.class));
    }

    @Test
    void shouldThrowWhenDtoIsInvalid() {
        OrderDTO dto = new OrderDTO("", "");
        when(orderValidator.isValid(dto)).thenReturn(false);
        assertThrows(IllegalArgumentException.class, () -> orderService.createOrder(dto));
        verify(orderRepository, never()).save(any());
    }

    @Test
    void shouldReturnAllOrders() {
        when(orderRepository.findAll()).thenReturn(List.of(new Order("Ana"), new Order("Ben")));
        assertEquals(2, orderService.getAllOrders().size());
    }

    @Test
    void shouldReturnEmptyList() {
        when(orderRepository.findAll()).thenReturn(List.of());
        assertTrue(orderService.getAllOrders().isEmpty());
    }

    @Test
    void shouldGetOrderById() {
        when(orderRepository.findById(1L)).thenReturn(Optional.of(new Order("Maria")));
        assertEquals("Maria", orderService.getOrderById(1L).getCustomerName());
    }

    @Test
    void shouldThrowWhenOrderNotFound() {
        when(orderRepository.findById(99L)).thenReturn(Optional.empty());
        assertThrows(OrderNotFoundException.class, () -> orderService.getOrderById(99L));
    }

    @Test
    void shouldDeleteOrderSuccessfully() {
        when(orderRepository.existsById(1L)).thenReturn(true);
        doNothing().when(orderRepository).deleteById(1L);
        assertDoesNotThrow(() -> orderService.deleteOrder(1L));
        verify(orderRepository).deleteById(1L);
    }

    @Test
    void shouldThrowWhenDeletingNonExistent() {
        when(orderRepository.existsById(99L)).thenReturn(false);
        assertThrows(OrderNotFoundException.class, () -> orderService.deleteOrder(99L));
    }
}
