# Refactoring Evidence

This folder contains evidence of the refactoring and testing work for the Rodenas SOLID + TDD Lab.

## What is included

- Before/after code comparison files
- Test results and edge case coverage
- Proof of SOLID principles, especially SRP, DIP, OCP, and immutability
- Changed file list with key refactor points

## Before / After files

- `code-comparison/before/OrderService.java`
- `code-comparison/after/OrderServiceImpl.java`

These files show the original `OrderService` from the GRASP UT Rodenas project and the refactored `OrderServiceImpl` using clean SOLID design.

## Changed files

- `src/main/java/com/rodenas/grasp/demo/DemoApplication.java`
- `src/main/java/com/rodenas/grasp/demo/controller/OrderController.java`
- `src/main/java/com/rodenas/grasp/demo/dto/OrderRequestDTO.java`
- `src/main/java/com/rodenas/grasp/demo/dto/OrderItemDTO.java`
- `src/main/java/com/rodenas/grasp/demo/entity/Order.java`
- `src/main/java/com/rodenas/grasp/demo/entity/OrderItem.java`
- `src/main/java/com/rodenas/grasp/demo/repository/OrderRepository.java`
- `src/main/java/com/rodenas/grasp/demo/service/OrderService.java`
- `src/main/java/com/rodenas/grasp/demo/service/OrderServiceImpl.java`
- `src/main/java/com/rodenas/grasp/demo/service/OrderValidator.java`
- `src/main/java/com/rodenas/grasp/demo/service/OrderValidatorImpl.java`
- `src/main/java/com/rodenas/grasp/demo/util/PriceCalculator.java`
- `src/main/java/com/rodenas/grasp/demo/util/PriceCalculatorImpl.java`
- `src/main/java/com/rodenas/grasp/demo/payment/PaymentProcessor.java`
- `src/main/java/com/rodenas/grasp/demo/payment/CashPaymentProcessor.java`
- `src/main/java/com/rodenas/grasp/demo/payment/GCashPaymentProcessor.java`
- `src/main/java/com/rodenas/grasp/demo/payment/CardPaymentProcessor.java`
- `src/main/java/com/rodenas/grasp/demo/exception/OrderNotFoundException.java`
- `src/main/java/com/rodenas/grasp/demo/exception/GlobalExceptionHandler.java`
- `src/test/java/com/rodenas/grasp/demo/service/OrderServiceImplTest.java`
- `src/test/java/com/rodenas/grasp/demo/service/OrderValidatorTest.java`
- `src/test/java/com/rodenas/grasp/demo/service/OrderItemImmutabilityTest.java`
- `src/test/java/com/rodenas/grasp/demo/payment/PaymentProcessorTest.java`
- `src/test/java/com/rodenas/grasp/demo/exception/OrderNotFoundExceptionTest.java`
- `refactoring-evidence/code-comparison/before/OrderService.java`
- `refactoring-evidence/code-comparison/after/OrderServiceImpl.java`

## Refactor summary

- Extracted validation into `OrderValidatorImpl` to follow SRP.
- Added the `PriceCalculator` abstraction to support testable VAT logic.
- Kept payment behavior polymorphic via `PaymentProcessor` implementations.
- Replaced the original concrete service with `OrderService` + `OrderServiceImpl` for DIP.
- Added unit tests for service orchestration, polymorphism, immutability, and missing record handling.
