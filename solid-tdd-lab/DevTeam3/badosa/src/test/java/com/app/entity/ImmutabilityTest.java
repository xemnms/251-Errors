package com.app.entity;

import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

import static org.junit.jupiter.api.Assertions.assertTrue;

class ImmutabilityTest {

    // OOP Best Practice: Immutability Verification — Uses reflection to ensure SalaryDetails remains fully immutable (final class, final fields, no setters).
    @Test
    void testSalaryDetailsIsImmutable() {
        Class<SalaryDetails> clazz = SalaryDetails.class;

        // Class must be final
        assertTrue(Modifier.isFinal(clazz.getModifiers()), "SalaryDetails class must be final");

        // All fields must be final
        for (Field field : clazz.getDeclaredFields()) {
            if (field.isSynthetic()) {
                continue; // Skip synthetic fields added by coverage/test tools
            }
            assertTrue(Modifier.isFinal(field.getModifiers()), "Field " + field.getName() + " must be final");
        }

        // There should be no setter methods
        for (Method method : clazz.getDeclaredMethods()) {
            assertTrue(!method.getName().startsWith("set"), "SalaryDetails must not contain setter methods: " + method.getName());
        }
    }

    // OOP Best Practice: Immutability Verification — Proves request DTO payload is immutable.
    @Test
    void testEmployeeDTOIsImmutable() {
        Class<com.app.dto.EmployeeDTO> clazz = com.app.dto.EmployeeDTO.class;

        // All fields in DTO should be final
        for (Field field : clazz.getDeclaredFields()) {
            if (field.isSynthetic()) {
                continue;
            }
            assertTrue(Modifier.isFinal(field.getModifiers()), "Field " + field.getName() + " in EmployeeDTO must be final");
        }

        // There should be no setter methods
        for (Method method : clazz.getDeclaredMethods()) {
            assertTrue(!method.getName().startsWith("set"), "EmployeeDTO must not contain setter methods: " + method.getName());
        }
    }
}
