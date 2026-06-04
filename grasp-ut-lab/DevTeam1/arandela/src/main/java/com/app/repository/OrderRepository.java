package com.app.repository;

import com.app.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

// GRASP: Indirection - decouples service from direct DB access
// GRASP: Protected Variations - swapping DB won't affect service
@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
}
