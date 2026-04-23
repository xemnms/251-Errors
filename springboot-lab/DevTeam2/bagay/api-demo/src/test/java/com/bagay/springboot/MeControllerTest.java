package com.bagay.springboot;

import java.util.Map;

import org.junit.jupiter.api.Test;
import com.bagay.springboot.controller.MeController;

class MeControllerTest {

    @Test
    void testGetMe() {
        MeController meController = new MeController();
        Map<String, Object> response = meController.getMe();

        if (!"Axel Drake M. Bagay".equals(response.get("name"))) {
            throw new AssertionError("Unexpected name value");
        }
        if (!"2025-1020735".equals(response.get("studentId"))) {
            throw new AssertionError("Unexpected studentId value");
        }
        if (!"Java Programming".equals(response.get("course"))) {
            throw new AssertionError("Unexpected course value");
        }
        if (!"Learning Spring Boot REST APIs!".equals(response.get("message"))) {
            throw new AssertionError("Unexpected message value");
        }
    }
}

