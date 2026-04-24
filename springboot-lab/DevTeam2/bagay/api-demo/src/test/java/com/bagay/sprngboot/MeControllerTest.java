package com.bagay.sprngboot;

import com.bagay.sprngboot.controller.MeController;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Test class for MeController endpoint
 * Tests the /me endpoint to ensure it returns proper JSON response
 */
public class MeControllerTest {

    private MeController meController = new MeController();

    @Test
    public void testGetMeReturnsNotNull() {
        assertNotNull(meController.getMe());
    }

    @Test
    public void testGetMeReturnsCorrectName() {
        assertEquals("Axe Drake M. Bagay", meController.getMe().get("name"));
    }

    @Test
    public void testGetMeReturnsCorrectStudentId() {
        assertEquals("2025-1020735", meController.getMe().get("studentId"));
    }

    @Test
    public void testGetMeReturnsCorrectCourse() {
        assertEquals("Java Programming", meController.getMe().get("course"));
    }

    @Test
    public void testGetMeContainsAllRequiredFields() {
        var response = meController.getMe();
        assertTrue(response.containsKey("name"));
        assertTrue(response.containsKey("studentId"));
        assertTrue(response.containsKey("course"));
        assertTrue(response.containsKey("message"));
    }
}

