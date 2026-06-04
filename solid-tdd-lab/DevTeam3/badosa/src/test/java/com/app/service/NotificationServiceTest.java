package com.app.service;

import com.app.entity.Employee;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

class NotificationServiceTest {

    private Employee employee;

    @BeforeEach
    void setUp() {
        employee = Employee.builder()
                .name("John Doe")
                .email("john.doe@example.com")
                .department("Engineering")
                .jobTitle("Developer")
                .salaryDetails(com.app.entity.SalaryDetails.builder().baseSalary(4500.0).allowance(500.0).build())
                .build();
    }

    @Test
    void testEmailNotificationServicePolymorphism() {
        NotificationService service = new EmailNotificationService();
        assertDoesNotThrow(() -> service.sendNotification(employee, "Hello via Email"));
    }

    @Test
    void testSmsNotificationServicePolymorphism() {
        NotificationService service = new SmsNotificationService();
        assertDoesNotThrow(() -> service.sendNotification(employee, "Hello via SMS"));
    }
}
