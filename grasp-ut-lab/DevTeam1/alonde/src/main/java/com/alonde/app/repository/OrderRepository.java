package com.alonde.app.repository;

import com.alonde.app.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

// grasp: indirection - acts as intermediary between service and DB
// grasp: polymorphism - inherits all CRUD methods from JpaRepository
@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {

    List<Order> findByCustomerNameContainingIgnoreCase(String name);
    List<Order> findByStatus(String status);
}