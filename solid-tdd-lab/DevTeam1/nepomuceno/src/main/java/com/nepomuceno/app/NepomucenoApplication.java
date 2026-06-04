package com.nepomuceno.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class NepomucenoApplication {

	public static void main(String[] args) {
		SpringApplication.run(NepomucenoApplication.class, args);
	}

}
/*
 * REFLECTION: Hardest GRASP Principle
 * =====================================
 * The hardest principle to apply was LOW COUPLING.
 *
 * At first, OrderService directly instantiated CreditCardPayment
 * and CashPayment inside the method — tightly binding the service
 * to specific implementations:
 *
 *   // BAD (high coupling):
 *   CreditCardPayment p = new CreditCardPayment();
 *   p.process(order);
 *
 * The fix was to inject a List<Payment> through the constructor,
 * so the service only depends on the Payment interface — not on
 * any concrete class. Adding a new payment type (e.g. GCash)
 * now requires zero changes to OrderService.
 *
 *   // GOOD (low coupling):
 *   private final List<Payment> payments;
 *   payments.stream().filter(p -> p.getType().equals(type))...
 */

/*
 * REFLECTION: Design Mistake I Fixed
 * =====================================
 * My original design put calculateTotal() inside OrderService
 * instead of inside the Order entity.
 *
 *   // WRONG — violates Information Expert:
 *   public double calculateTotal(Order order) {
 *       return order.getItems().stream()
 *                  .mapToDouble(i -> i.getPrice() * i.getQuantity())
 *                  .sum();
 *   }
 *
 * This was wrong because OrderService does not own the data —
 * Order does. Putting the logic in the service forced it to
 * reach into Order's internals, breaking encapsulation and
 * making the service do work it shouldn't be responsible for.
 *
 * The fix was to move calculateTotal() into the Order entity,
 * which is exactly what the Information Expert principle requires:
 * assign responsibility to the class that has the information
 * needed to fulfill it.
 *
 *   // CORRECT — follows Information Expert:
 *   // Inside Order.java:
 *   public double calculateTotal() {
 *       return items.stream()
 *                   .mapToDouble(OrderItem::getSubtotal)
 *                   .sum();
 *   }
 */