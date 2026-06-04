package com.fullstack.lab.bagay.service;

import com.fullstack.lab.bagay.model.Employee;
import com.fullstack.lab.bagay.repository.EmployeeRepository;
import com.fullstack.lab.bagay.strategy.EmployeeSearchStrategy;
import jakarta.persistence.EntityNotFoundException;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;


class EmployeeServicePhaseRunnerTest {

    private static final TestPhase SELECTED_PHASE = new RefactorPhase();

    @Test
    void runSelectedPhase() {
        SELECTED_PHASE.run();
    }

    private interface TestPhase {
        void run();
    }

    // ---------------------- RED PHASE ----------------------------
    static class RedPhase implements TestPhase {
        @Override
        public void run() {
            EmployeeRepository repo = Mockito.mock(EmployeeRepository.class);
            EmployeeService service = new EmployeeService(repo, List.of());

            Mockito.when(repo.findById(1L)).thenReturn(Optional.empty());

            EntityNotFoundException ex = assertThrows(EntityNotFoundException.class,
                    () -> service.getEmployeeById(1L));
            assertEquals("Employee not found with id: 1", ex.getMessage());
        }
    }

    // ---------------------- GREEN PHASE --------------------------
    static class GreenPhase implements TestPhase {
        @Override
        public void run() {
            EmployeeRepository repo = Mockito.mock(EmployeeRepository.class);
            EmployeeSearchStrategy s1 = Mockito.mock(EmployeeSearchStrategy.class);
            EmployeeSearchStrategy s2 = Mockito.mock(EmployeeSearchStrategy.class);

            EmployeeService service = new EmployeeService(repo, List.of(s1, s2));

            // Create
            Employee toCreate = sampleEmployee(null);
            Employee saved = sampleEmployee(10L);
            Mockito.when(repo.save(toCreate)).thenReturn(saved);
            Employee result = service.createEmployee(toCreate);
            assertEquals(saved, result);

            // Get all
            List<Employee> all = List.of(sampleEmployee(1L), sampleEmployee(2L));
            Mockito.when(repo.findAll()).thenReturn(all);
            assertEquals(all, service.getAllEmployees());

            // Update
            Employee existing = sampleEmployee(5L);
            Employee updateReq = sampleEmployee(null);
            updateReq.setFirstName("Updated");
            Mockito.when(repo.findById(5L)).thenReturn(Optional.of(existing));
            Mockito.when(repo.save(Mockito.any(Employee.class))).thenAnswer(i -> i.getArgument(0));

            Employee updated = service.updateEmployee(5L, updateReq);
            assertEquals(5L, updated.getId());
            assertEquals("Updated", updated.getFirstName());
        }
    }

    // -------------------- REFACTOR PHASE ------------------------
    static class RefactorPhase implements TestPhase {
        @Override
        public void run() {
            EmployeeRepository repo = Mockito.mock(EmployeeRepository.class);
            EmployeeSearchStrategy firstNameStrategy = Mockito.mock(EmployeeSearchStrategy.class);
            EmployeeSearchStrategy lastNameStrategy = Mockito.mock(EmployeeSearchStrategy.class);

            EmployeeService service = new EmployeeService(repo, List.of(firstNameStrategy, lastNameStrategy));

            // Search delegation (polymorphism) should choose the right strategy
            Employee e = sampleEmployee(2L);
            Mockito.when(firstNameStrategy.supports("firstName")).thenReturn(true);
            Mockito.when(lastNameStrategy.supports("firstName")).thenReturn(false);
            Mockito.when(firstNameStrategy.search(repo, "Axel")).thenReturn(List.of(e));

            List<Employee> found = service.searchEmployees("firstName", "Axel");
            assertEquals(1, found.size());
            assertEquals(e, found.get(0));
        }
    }

    // ------- helper -------
    private static Employee sampleEmployee(Long id) {
        Employee employee = new Employee(
                "Axel",
                "Bagay",
                "axel.bagay@example.com",
                "Developer",
                new BigDecimal("45000.00"),
                LocalDate.of(2026, 5, 13),
                true
        );
        employee.setId(id);
        return employee;
    }
}
