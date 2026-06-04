# Rodenas SOLID + TDD Lab

This project reuses the Rodenas GRASP UT Spring Boot application and refactors it for the SOLID + Unit Testing Lab.

## What changed

- Added explicit validation service (`OrderValidator`) to enforce SRP.
- Created `OrderService` interface and `OrderServiceImpl` implementation for DIP.
- Kept payment processing polymorphic via `PaymentProcessor` implementations.
- Introduced `PriceCalculator` abstraction for testable VAT and discount logic.
- Added immutable request DTOs using Java records for immutability proof.
- Added service-layer unit tests with Mockito, polymorphism tests, and edge case coverage.

## Run tests

From this module:

```bash
mvn test
```

## Lab structure

- `src/main/java` - application code
- `src/test/java` - unit tests
- `refactoring-evidence` - refactor notes and evidence
