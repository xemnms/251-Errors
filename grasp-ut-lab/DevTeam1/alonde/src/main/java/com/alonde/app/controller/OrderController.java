package com.alonde.app.controller;

import com.alonde.app.dto.*;
import com.alonde.app.service.OrderService;
import jakarta.validation.Valid;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import java.util.List;

// grasp: controller - handles HTTP events and delegates to OrderService
@RestController
@RequestMapping("/api/orders")
@CrossOrigin(origins = "*")
public class OrderController {

    private final OrderService service;

    public OrderController(OrderService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<OrderResponse> create(@Valid @RequestBody CreateOrderRequest req) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.createOrder(req));
    }

    @GetMapping
    public List<OrderResponse> getAll() {
        return service.getAllOrders();
    }

    @GetMapping("/{id}")
    public OrderResponse getOne(@PathVariable Long id) {
        return service.getOrderById(id);
    }

    @PatchMapping("/{id}/cancel")
    public ResponseEntity<Void> cancel(@PathVariable Long id) {
        service.cancelOrder(id);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.deleteOrder(id);
        return ResponseEntity.noContent().build();
    }
}
