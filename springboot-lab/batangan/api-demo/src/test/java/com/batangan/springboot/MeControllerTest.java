package com.batangan.springboot;

import com.batangan.springboot.controller.MeController;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.beans.factory.annotation.Autowired;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class MeControllerTest {

	// Injects the actual controller bean from the Spring application context
    @Autowired
    private MeController meController;

    @Test
    public void testGetMe() throws Exception {
        var response = meController.getMe();
        
     // Verifies that the returned "name" value matches expected output
        assertThat(response.get("name")).isEqualTo("Clisha Rae V. Batangan");
        
     // Verifies that the returned "studentId" is correct
        assertThat(response.get("studentId")).isEqualTo("2025-1027945");
    }
}