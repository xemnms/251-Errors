package com.app.repository;

import com.app.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

// GRASP: Indirection - Repository separates service logic from database access.
@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
}
