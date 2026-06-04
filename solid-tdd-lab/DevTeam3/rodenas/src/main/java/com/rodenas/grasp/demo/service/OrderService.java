package com.rodenas.grasp.demo.service;

import com.rodenas.grasp.demo.dto.OrderRequestDTO;
import com.rodenas.grasp.demo.entity.Order;

import java.util.List;

// DIP: Controllers use this abstraction instead of depending on OrderServiceImpl.
public interface OrderService {
    Order createOrder(OrderRequestDTO dto);
    List<Order> getAllOrders();
    Order getOrderById(Long id);
    List<Order> getOrdersByStatus(String status);
    Order updateOrderStatus(Long id, String status);
    void deleteOrder(Long id);
    double getOrderTotalWithVat(Long id);
    String getReceipt(Long id);
}
