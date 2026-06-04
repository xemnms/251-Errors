# 🚀 SOLID + TDD Refactoring Lab — Badosa, Bien Manuel P.

## 📌 Overview

This project is a **refactored** version of the GRASP + Unit Testing Lab Employee Management System, enhanced to demonstrate all 5 **SOLID** principles, key **OOP best practices**, and comprehensive **TDD** validation using **JUnit 5** and **Mockito**.

---

## 🧩 SOLID Principles Implemented

| Principle | Implementation | Key File(s) |
|:---|:---|:---|
| **SRP** | Extracted validation logic from `EmployeeServiceImpl` into `EmployeeValidator` | `util/EmployeeValidator.java` |
| **OCP** | Created `TaxStrategy` interface with pluggable strategy implementations | `util/TaxStrategy.java`, `StandardTaxStrategy.java`, `HighIncomeTaxStrategy.java` |
| **LSP** | Tax strategies are fully interchangeable and obey the same contract | `util/TaxStrategyTest.java` |
| **ISP** | Split fat `EmployeeService` into `EmployeeQueryService` and `EmployeeCommandService` | `service/EmployeeQueryService.java`, `service/EmployeeCommandService.java` |
| **DIP** | Controller depends on interface abstractions, not concrete implementations | `controller/EmployeeController.java` |

## 💎 OOP Best Practices Implemented

| Practice | Implementation |
|:---|:---|
| **Composition Over Inheritance** | `Employee` HAS-A `SalaryDetails` (embedded value object) instead of subclassing |
| **Immutability** | `SalaryDetails` has final fields and no setters; `EmployeeDTO` uses `@Value` |
| **DRY** | Shared validation methods in `EmployeeValidator` reused across create/update |
| **KISS** | Factory method `getStrategyForSalary()` simplifies tax strategy selection |
| **YAGNI** | No unnecessary abstractions — only code that serves an immediate purpose |

---

## 🧪 Test Results

```text
Tests run: 26, Failures: 0, Errors: 0, Skipped: 0
BUILD SUCCESS
```

| Test Class | # Tests | Validates |
|:---|:---:|:---|
| `EmployeeControllerTest` | 3 | REST endpoint mappings with mocked services |
| `EmployeeServiceImplTest` | 8 | CRUD operations, validator delegation, edge cases |
| `NotificationServiceTest` | 2 | Polymorphic SMS/Email dispatch |
| `EmployeeValidatorTest` | 4 | Email format, duplicates, salary validation |
| `SalaryCalculatorTest` | 4 | Tax strategy delegation, net pay calculation |
| `TaxStrategyTest` | 3 | LSP equivalence, OCP extensibility |
| `ImmutabilityTest` | 2 | Final fields on `SalaryDetails` and `EmployeeDTO` |

---

## 📁 Project Structure

```text
badosa/
 ├── src/main/java/com/app/
 │   ├── controller/EmployeeController.java
 │   ├── dto/EmployeeDTO.java
 │   ├── entity/Employee.java, SalaryDetails.java
 │   ├── exception/ResourceNotFoundException.java
 │   ├── repository/EmployeeRepository.java
 │   ├── service/EmployeeService.java, EmployeeServiceImpl.java,
 │   │         EmployeeQueryService.java, EmployeeCommandService.java,
 │   │         NotificationService.java, EmailNotificationService.java,
 │   │         SmsNotificationService.java
 │   └── util/SalaryCalculator.java, EmployeeValidator.java,
 │            TaxStrategy.java, StandardTaxStrategy.java,
 │            HighIncomeTaxStrategy.java
 ├── src/test/java/com/app/
 │   ├── controller/EmployeeControllerTest.java
 │   ├── entity/ImmutabilityTest.java
 │   ├── service/EmployeeServiceImplTest.java, NotificationServiceTest.java
 │   └── util/EmployeeValidatorTest.java, SalaryCalculatorTest.java, TaxStrategyTest.java
 ├── refactoring-evidence/
 │   ├── evidence.md
 │   └── crud_verification.webp
 └── README.md
```

---

## 🔄 Review and Retrospect

### Which principle improved your design the most?

**Interface Segregation Principle (ISP)** had the biggest impact. Splitting the fat `EmployeeService` into `EmployeeQueryService` and `EmployeeCommandService` made the controller cleaner and made it obvious which operations each endpoint needed. It also made testing much easier since mocks only needed the relevant interface.

### What bad design did you remove?

- **God class**: `EmployeeServiceImpl` was doing validation, persistence, and notification all at once. Extracting `EmployeeValidator` separated the concerns.
- **Fat interface**: The original `EmployeeService` forced all clients to depend on both read and write operations.
- **Hardcoded tax logic**: `SalaryCalculator` had inline conditional tax rates that needed modification for every new bracket.

### Which principle was hardest to apply?

**Open-Closed Principle (OCP)** was the hardest because the existing `SalaryCalculator` was a simple utility class. Refactoring it to accept pluggable `TaxStrategy` implementations while keeping the existing API compatible required careful design.

---

## ▶️ How to Run

### Backend (Spring Boot on port 8080)
```bash
.\mvnw.cmd spring-boot:run
```

### Frontend (Vite React on port 5173)
```bash
cd ../../oop-fullstack-lab/DevTeam3/badosa/frontend
npm run dev
```

### Run Tests
```bash
.\mvnw.cmd test
```
