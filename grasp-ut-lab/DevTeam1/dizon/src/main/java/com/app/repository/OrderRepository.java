package com.app.repository;

import com.app.entity.Order;
import com.app.entity.OrderStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

// GRASP: Indirection - acts as an intermediary layer between the database and the service
// GRASP: Pure Fabrication - not a real-world domain concept; created purely for separation of concerns
@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
    List<Order> findByStatus(OrderStatus status);
    List<Order> findByCustomerName(String customerName);
}
