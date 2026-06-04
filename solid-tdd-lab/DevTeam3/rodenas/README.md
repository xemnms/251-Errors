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

```powershell
cd C:\Users\keysi\Downloads\251-Errors-solid-refactor-ut-rodenas\251-Errors-solid-refactor-ut-rodenas\solid-tdd-lab\DevTeam3\rodenas
mvn test
```

Note: run the command in the folder that has `pom.xml`. If you run it from the outer downloaded folder, Maven will fail because there is no project file there.

If using `mvnw.cmd`, set `JAVA_HOME` first:

```powershell
$env:JAVA_HOME="C:\Users\keysi\AppData\Local\Programs\Eclipse Adoptium\jdk-25.0.1.8-hotspot"
.\mvnw.cmd test
```

## Lab structure

- `src/main/java` - application code
- `src/test/java` - unit tests
- `refactoring-evidence` - refactor notes and evidence

## Checklist status

- [x] Existing project reused
- [x] SOLID principles implemented
- [x] OOP best practices implemented
- [x] Mockito used correctly
- [x] At least 10 meaningful unit tests
- [x] Edge cases tested
- [x] Refactoring evidence added
- [x] Screen recording added manually by student

## Review and retrospect

- Which principle improved the design the most? DIP helped the most because the controller and tests can use interfaces instead of depending on one concrete service class.
- What bad design was removed? Validation, price calculation, payment processing, and persistence were separated so the service is not doing everything alone.
- Which principle was hardest to apply? OCP was hardest because payment logic needed to be moved into separate implementations so new payment types can be added safely.

## Changelog

Kyla Rodenas 2026-06-04 SOLID-UT Completed

## Personal reflection

2026-06-04 : i learned how to separate responsibilities better and improved the project by adding interface-based services, validation, and unit tests.
