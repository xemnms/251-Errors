package com.app.costiniano.service;

import com.app.costiniano.dto.ItemDto;
import com.app.costiniano.dto.OrderRequestDto;
import com.app.costiniano.dto.OrderResponseDto;
import com.app.costiniano.entity.Order;
import com.app.costiniano.repository.OrderRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;

import static org.junit.jupiter.api.Assertions.*;

class OrderServiceTest {

    private OrderService orderService;
    private MockOrderRepository mockOrderRepository;

    // A lightweight manual anonymous implementation of our OrderRepository interface
    private static class MockOrderRepository implements OrderRepository {
        public Order lastSavedOrder;
        public int saveCount = 0;

        @Override
        public <S extends Order> S save(S entity) {
            saveCount++;
            entity.setId((long) saveCount);
            this.lastSavedOrder = entity;
            return entity;
        }

        // Unused JpaRepository template stub methods
        @Override public void flush() {}
        @Override public <S extends Order> S saveAndFlush(S entity) { return null; }
        @Override public <S extends Order> List<S> saveAllAndFlush(Iterable<S> entities) { return null; }
        @Override public void deleteAllInBatch(Iterable<Order> entities) {}
        @Override public void deleteAllByIdInBatch(Iterable<Long> ids) {}
        @Override public void deleteAllInBatch() {}
        @Override public Order getOne(Long id) { return null; }
        @Override public Order getById(Long id) { return null; }
        @Override public Order getReferenceById(Long id) { return null; }
        @Override public <S extends Order> List<S> findAll(Example<S> example) { return null; }
        @Override public <S extends Order> List<S> findAll(Example<S> example, Sort sort) { return null; }
        @Override public List<Order> findAll() { return null; }
        @Override public List<Order> findAll(Sort sort) { return null; }
        @Override public List<Order> findAllById(Iterable<Long> ids) { return null; }
        @Override public <S extends Order> List<S> saveAll(Iterable<S> entities) { return null; }
        @Override public Optional<Order> findById(Long id) { return Optional.empty(); }
        @Override public boolean existsById(Long id) { return false; }
        @Override public long count() { return 0; }
        @Override public void deleteById(Long id) {}
        @Override public void delete(Order entity) {}
        @Override public void deleteAllById(Iterable<? extends Long> ids) {}
        @Override public void deleteAll(Iterable<? extends Order> entities) {}
        @Override public void deleteAll() {}
        @Override public Page<Order> findAll(Pageable pageable) { return null; }
        @Override public <S extends Order> Optional<S> findOne(Example<S> example) { return Optional.empty(); }
        @Override public <S extends Order> Page<S> findAll(Example<S> example, Pageable pageable) { return null; }
        @Override public <S extends Order> long count(Example<S> example) { return 0; }
        @Override public <S extends Order> boolean exists(Example<S> example) { return false; }
        @Override public <S extends Order, R> R findBy(Example<S> example, Function<FluentQuery.FetchableFluentQuery<S>, R> queryFunction) { return null; }
    }

    @BeforeEach
    void setUp() {
        mockOrderRepository = new MockOrderRepository();
        List<PaymentStrategy> strategies = List.of(new CardPaymentStrategy(), new PixPaymentStrategy());
        orderService = new OrderService(mockOrderRepository, strategies);
    }

    @Test
    void shouldCreateOrderSuccessfully_WithCardPayment() {
        // Arrange
        OrderRequestDto request = new OrderRequestDto(
                List.of(new ItemDto("Laptop", 1000.0, 1), new ItemDto("Mouse", 50.0, 2)), "CARD"
        );

        // Act
        OrderResponseDto response = orderService.checkout(request);

        // Assert
        assertNotNull(response);
        assertEquals(1L, response.id());
        assertEquals(1100.0, response.totalAmount());
        assertEquals("PAID_VIA_CARD", response.status());
        assertEquals(1, mockOrderRepository.saveCount);
    }

    @Test
    void shouldCreateOrderSuccessfully_WithPixPayment() {
        // Arrange
        OrderRequestDto request = new OrderRequestDto(List.of(new ItemDto("Book", 20.0, 1)), "PIX");

        // Act
        OrderResponseDto response = orderService.checkout(request);

        // Assert
        assertEquals("PAID_VIA_PIX", response.status());
        assertEquals(20.0, response.totalAmount());
    }

    @Test
    void shouldThrowException_WhenItemsListIsEmpty() {
        // Arrange
        OrderRequestDto request = new OrderRequestDto(Collections.emptyList(), "CARD");

        // Act & Assert
        assertThrows(IllegalArgumentException.class, () -> orderService.checkout(request));
        assertEquals(0, mockOrderRepository.saveCount);
    }

    @Test
    void shouldThrowException_WhenItemsListIsNull() {
        // Arrange
        OrderRequestDto request = new OrderRequestDto(null, "CARD");

        // Act & Assert
        assertThrows(IllegalArgumentException.class, () -> orderService.checkout(request));
    }

    @Test
    void shouldThrowException_WhenPaymentMethodIsInvalid() {
        // Arrange
        OrderRequestDto request = new OrderRequestDto(List.of(new ItemDto("Pen", 1.5, 10)), "CRYPTO");

        // Act & Assert
        Exception exception = assertThrows(IllegalArgumentException.class, () -> orderService.checkout(request));
        assertTrue(exception.getMessage().contains("Unsupported payment method"));
    }
}