package com.acosta.springboot.service;

import com.acosta.springboot.dto.OrderRequest;
import com.acosta.springboot.dto.OrderResponse;
import com.acosta.springboot.entity.Order;
import com.acosta.springboot.entity.OrderItem;
import com.acosta.springboot.repository.OrderRepository;
import com.acosta.springboot.exception.OrderNotFoundException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

// @ExtendWith tells JUnit to use Mockito for this test class
@ExtendWith(MockitoExtension.class)
class OrderServiceTest {

    // --- Mocks (fake versions of dependencies) ---

    @Mock
    OrderRepository orderRepository;       // fake DB — no real database calls

    @Mock
    PaymentProcessorFactory paymentProcessorFactory;

    @Mock
    PaymentProcessor paymentProcessor;

    @Mock
    OrderValidator orderValidator;
    // --- The real class we are testing ---

    @InjectMocks
    OrderService orderService;             // real service, but uses the mocks above

    // =========================================================
    // TEST 1: Creating an order successfully
    // =========================================================
    @Test
    void shouldCreateOrderSuccessfully() {
        // --- ARRANGE: set up the data and tell mocks what to return ---

        // Build a fake request (what the client would send)
        List<OrderRequest.OrderItemRequest> items = new ArrayList<>();
        items.add(new OrderRequest.OrderItemRequest("Burger", 99.0, 2));

        OrderRequest request = new OrderRequest("Juan", items, "CASH");

        // Build a fake Order that the repository will pretend to save and return
        Order fakeOrder = new Order("Juan");
        fakeOrder.addItem(new OrderItem("Burger", 99.0, 2));

        // "When save() is called with any Order, return our fakeOrder"
        when(orderRepository.save(any(Order.class))).thenReturn(fakeOrder);

        when(paymentProcessorFactory.getProcessor("CASH")).thenReturn(paymentProcessor);

        // --- ACT: call the method we are testing ---
        OrderResponse response = orderService.createOrder(request);

        // --- ASSERT: check the results are what we expect ---
        assertNotNull(response);                          // response should not be null
        assertEquals("Juan", response.getCustomerName()); // name should match
        assertEquals(198.0, response.getTotal());         // 99.0 x 2 = 198.0

        // Verify that save() was actually called (at least once)
        verify(orderRepository, atLeastOnce()).save(any(Order.class));
    }

    // =========================================================
    // TEST 2: Getting an order by ID
    // =========================================================
    @Test
    void shouldReturnOrderById() {
        // --- ARRANGE ---

        // Build a fake order to return from the repository
        Order fakeOrder = new Order("Maria");
        fakeOrder.addItem(new OrderItem("Pizza", 150.0, 1));

        // "When findById(1) is called, return Optional containing fakeOrder"
        // Optional.of() means: "it was found"
        when(orderRepository.findById(1L)).thenReturn(Optional.of(fakeOrder));

        // --- ACT ---
        OrderResponse response = orderService.getOrderById(1L);

        // --- ASSERT ---
        assertNotNull(response);
        assertEquals("Maria", response.getCustomerName());
        assertEquals(150.0, response.getTotal());
    }

    // =========================================================
    // TEST 3: Getting an order that does NOT exist
    // =========================================================
    @Test
void shouldThrowExceptionWhenOrderNotFound() {
    when(orderRepository.findById(99L)).thenReturn(Optional.empty());

    // DIP PROOF: Testing through the interface behavior
    // Now expects our specific custom exception
    assertThrows(OrderNotFoundException.class, () -> {
        orderService.getOrderById(99L);
    });
}

    // =========================================================
    // TEST 4: Edge case — empty customer name should fail
    // =========================================================
    @Test
void shouldThrowExceptionWhenCustomerNameIsEmpty() {
    // --- ARRANGE ---
    List<OrderRequest.OrderItemRequest> items = new ArrayList<>();
    items.add(new OrderRequest.OrderItemRequest("Burger", 99.0, 1));

    OrderRequest request = new OrderRequest("", items, "CASH");

    // DIP PROOF: We mock the interface, not the concrete class
    // Tell the mock validator to throw when it sees this bad request
    doThrow(new IllegalArgumentException("Customer name cannot be empty"))
            .when(orderValidator).validate(request);

    // --- ACT & ASSERT ---
    assertThrows(IllegalArgumentException.class, () -> {
        orderService.createOrder(request);
    });

    verify(orderRepository, never()).save(any(Order.class));
}

    // =========================================================
    // TEST 5: Edge case — empty item list should fail
    // =========================================================
    @Test
void shouldThrowExceptionWhenItemListIsEmpty() {
    // --- ARRANGE ---
    OrderRequest request = new OrderRequest("Juan", new ArrayList<>(), "CASH");

    // Tell the mock validator to throw when it sees this bad request
    doThrow(new IllegalArgumentException("Order must have at least one item"))
            .when(orderValidator).validate(request);

    // --- ACT & ASSERT ---
    assertThrows(IllegalArgumentException.class, () -> {
        orderService.createOrder(request);
    });

    verify(orderRepository, never()).save(any(Order.class));
}

    // =========================================================
    // TEST 6: Getting all orders
    // =========================================================
    @Test
    void shouldReturnAllOrders() {
        // --- ARRANGE ---

        // Build a fake list of orders the repository will return
        List<Order> fakeOrders = new ArrayList<>();
        fakeOrders.add(new Order("Juan"));
        fakeOrders.add(new Order("Maria"));

        when(orderRepository.findAll()).thenReturn(fakeOrders);

        // --- ACT ---
        List<OrderResponse> responses = orderService.getAllOrders();

        // --- ASSERT ---
        assertEquals(2, responses.size());  // should get back 2 orders
    }

    // =========================================================
    // TEST 7: Updating an order's status
    // =========================================================
    @Test
    void shouldUpdateOrderStatus() {
        // --- ARRANGE ---

        Order fakeOrder = new Order("Jan");

        when(orderRepository.findById(1L)).thenReturn(Optional.of(fakeOrder));
        when(orderRepository.save(any(Order.class))).thenReturn(fakeOrder);

        // --- ACT ---
        OrderResponse response = orderService.updateStatus(1L, "COMPLETED");

        // --- ASSERT ---
        assertEquals("COMPLETED", response.getStatus());

        // Make sure save() was called to store the new status
        verify(orderRepository).save(any(Order.class));
    }

    // =========================================================
    // TEST 8: Deleting an order that exists
    // =========================================================
    @Test
    void shouldDeleteOrderSuccessfully() {
        // --- ARRANGE ---

        // "When existsById(1) is called, return true — the order exists"
        when(orderRepository.existsById(1L)).thenReturn(true);

        // --- ACT ---
        orderService.deleteOrder(1L);

        // --- ASSERT ---

        // Verify deleteById was actually called with ID 1
        verify(orderRepository).deleteById(1L);
    }
}
