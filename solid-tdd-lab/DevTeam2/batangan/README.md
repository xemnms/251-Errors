# Task Manager — SOLID Refactoring Lab

## Project Overview
A Spring Boot Task Management system refactored to apply
SOLID principles, OOP best practices, and clean architecture.
Controller already followed SRP and DIP.

## Where Good Design Already Existed
TaskController.java
  → Already follows SRP (HTTP only, no business logic)
  → Already follows DIP (depends on TaskService interface)
  → GRASP: Controller principle already correctly applied

TaskRepository.java
  → Already follows DIP (JpaRepository is an interface)
  → Already follows GRASP: Indirection principle
  → No changes needed

Task.java (entity)
  → Already follows GRASP: Information Expert
  → isCompleted(), isHighPriority() in the right place

TaskNotifier interface + implementations
  → Already follows OCP and LSP
  → Already demonstrates Polymorphism (from Lab 1)

## SOLID Principles Applied

### S — Single Responsibility Principle
- TaskValidator.java: handles ONLY validation logic
- TaskMapper.java: handles ONLY DTO-to-entity conversion
- TaskServiceImpl.java: handles ONLY business logic orchestration

### O — Open-Closed Principle
- TaskNotifier interface: add new notification types without
  changing existing code (EmailTaskNotifier, ConsoleTaskNotifier)
- TaskPriorityHandler interface: add new priority rules without
  editing the service

### L — Liskov Substitution Principle
- Both EmailTaskNotifier and ConsoleTaskNotifier can replace
  TaskNotifier anywhere without breaking behavior

### I — Interface Segregation Principle
- TaskReader interface: read-only operations
- TaskWriter interface: write operations
- TaskService extends both (only where needed)

### D — Dependency Inversion Principle
- TaskController depends on TaskService interface, not TaskServiceImpl
- TaskServiceImpl depends on TaskRepository interface, not H2 directly

## OOP Best Practices
- DRY: Shared validation in TaskValidator (no repeated null checks)
- KISS: Each method does one simple thing
- YAGNI: No unused methods or over-engineered abstractions
- Immutability: TaskDTO uses final fields with builder pattern
- Composition: TaskServiceImpl HAS-A TaskValidator, not extends it

## Test Coverage
- 12 unit tests in TaskServiceImplTest
- 4 polymorphism tests in TaskNotifierTest
- 3 immutability tests in TaskDTOTest
- Edge cases: null, empty, missing records

## How to Run
mvn spring-boot:run

## How to Run Tests
mvn test

## Review and Retrospect

1. Which principle improved your design the most?
- DIP improved my design the most because it reduced tight coupling and made my system easier to test using Mockito by depending on interfaces instead of concrete classes.

2. What bad design did you remove?
- I removed God classes, long if-else conditions, and hardcoded dependencies. These were replaced with smaller services, polymorphism, and dependency injection.

3. Which principle was hardest to apply?
- OCP was the hardest because it required redesigning logic into interfaces and polymorphic classes instead of simple conditionals.
