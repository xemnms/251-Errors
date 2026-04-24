package com.arandela.springboot;

import com.bagay.sprngboot.controller.MeController;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
public class MeControllerTest {

    private MeController meController = new MeController();

    @Test
    public void testGetMeReturnsNotNull() {
        assertNotNull(meController.getMe());
    }

    @Test
    public void testGetMeReturnsCorrectName() {
        assertEquals("Jherrymei D. Arandela", meController.getMe().get("name"));
    }

    @Test
    public void testGetMeReturnsCorrectStudentId() {
        assertEquals("2025-1029981", meController.getMe().get("studentId"));
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

