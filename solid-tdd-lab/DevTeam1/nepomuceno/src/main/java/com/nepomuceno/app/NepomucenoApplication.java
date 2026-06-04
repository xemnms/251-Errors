package com.nepomuceno.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class NepomucenoApplication {

	public static void main(String[] args) {
		SpringApplication.run(NepomucenoApplication.class, args);
	}

}
// ============================================================
// RETROSPECTIVE COMMENTS — SOLID + OOP Refactoring Lab
// ============================================================

// ------------------------------------------------------------
// Q1: Which principle improved your design the most?
// ------------------------------------------------------------
// ANSWER: Single Responsibility Principle (SRP)
//
// Before refactoring, OrderService handled three responsibilities:
//   1. Input validation (null checks, empty checks, price checks)
//   2. Response mapping (private toResponse() method)
//   3. Business logic (createOrder, processPayment, etc.)
//
// After applying SRP:
//   - Validation → extracted to OrderValidatorImpl
//   - Mapping    → extracted to OrderMapperImpl
//   - OrderService now has ONE reason to change: business rules only
//
// Proof: In tests, OrderValidator and OrderMapper can be mocked
// independently — confirming each concern is truly isolated.
// When validation rules change, only OrderValidatorImpl changes.
// When response shape changes, only OrderMapperImpl changes.

// ------------------------------------------------------------
// Q2: What bad design did you remove?
// ------------------------------------------------------------
// ANSWER: Three specific bad designs were identified and removed:
//
// BAD DESIGN #1 — Scattered inline validation (violates SRP)
//   BEFORE: null/empty/price checks were hardcoded inside createOrder()
//   AFTER:  all rules centralised in OrderValidatorImpl.validateRequest()
//
// BAD DESIGN #2 — Hardcoded if-else payment routing (violates OCP)
//   BEFORE: if (type.equals("CREDIT_CARD")) { ... }
//           else if (type.equals("CASH")) { ... }
//           Adding a new payment type required modifying OrderService.
//   AFTER:  resolvePayment() uses a stream over injected Payment
//           implementations. New types are added by creating a new
//           class — OrderService is never touched.
//
// BAD DESIGN #3 — Mutable DTOs (violates Immutability)
//   BEFORE: OrderRequest and ItemDto had setters — any layer could
//           silently modify validated data mid-flight.
//   AFTER:  All fields are final, no setters exist, and the item list
//           is wrapped in Collections.unmodifiableList(). Data cannot
//           change after construction.

// ------------------------------------------------------------
// Q3: Which principle was hardest to apply?
// ------------------------------------------------------------
// ANSWER: Dependency Inversion Principle (DIP)
//
// DIP was the hardest because it required a mindset shift:
// instead of thinking "I need a CreditCardPayment object",
// the thinking had to become "I need something that implements Payment".
//
// The specific challenge was the List<Payment> injection.
// Mockito cannot automatically inject a List of mocked objects
// via @InjectMocks — it had to be constructed manually in @BeforeEach:
//
//   orderService = new OrderService(
//       orderRepository,
//       List.of(creditCardPayment, cashPayment),  // manual wiring
//       orderValidator,
//       orderMapper
//   );
//
// This revealed that DIP is not just about using interfaces —
// it also requires careful thought about HOW dependencies are
// assembled and injected, especially in unit tests where the
// Spring container is not running.