package com.dizon.app.repository;

import com.dizon.app.entity.Order;
import com.dizon.app.entity.OrderStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

// SOLID: DIP - this is an abstraction (interface). OrderService depends on THIS,
// never on a concrete database class. Spring Data supplies the implementation at runtime.
// GOOD DESIGN PRESERVED: already an interface in the GRASP version, so it already
// satisfied DIP. Kept as-is and documented.
@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
    List<Order> findByStatus(OrderStatus status);
    List<Order> findByCustomerName(String customerName);
}
