package com.arandela.springboot.controller;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Map;

/**
 * MeControllerTest - Tests for the MeController REST endpoint
 */
public class MeControllerTest {

    @Test
    public void testGetMe() {
        MeController controller = new MeController();
        Map<String, Object> response = controller.getMe();

        assertNotNull(response, "Response should not be null");
        assertTrue(response.containsKey("name"), "Response should contain 'name' field");
        assertTrue(response.containsKey("studentId"), "Response should contain 'studentId' field");
        assertTrue(response.containsKey("course"), "Response should contain 'course' field");
        assertTrue(response.containsKey("message"), "Response should contain 'message' field");
        assertEquals("Java Programming", response.get("course"), "Course should be 'Java Programming'");
    }
}

