package com.bautista.grasp.controller;

import com.bautista.grasp.dto.OrderRequestDTO;
import com.bautista.grasp.dto.OrderResponseDTO;
import com.bautista.grasp.service.OrderService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;

/*
 * GRASP: Controller
 * Responsibility: Handle HTTP requests and delegate to service layer only.
 */
@RestController
@RequestMapping("/api/orders")
public class OrderController {

    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    /*
     * GRASP: Controller
     * No business logic is allowed here.
     */
    @PostMapping
    public ResponseEntity<OrderResponseDTO> createOrder(
            @Valid @RequestBody OrderRequestDTO request) {

        return ResponseEntity.ok(orderService.createOrder(request));
    }

    /*
     * GRASP: Controller
     * Delegates computation to service layer.
     */
    @GetMapping("/{id}/total")
    public ResponseEntity<Double> getOrderTotal(@PathVariable Long id) {

        double total = orderService.getOrderTotal(id);
        return ResponseEntity.ok(total);
    }
}