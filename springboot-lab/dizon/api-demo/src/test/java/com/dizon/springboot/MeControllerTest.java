package com.dizon.springboot;

import com.dizon.springboot.controller.MeController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureWebMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.*;

// @SpringBootTest loads the full Spring application context for testing
// This follows the testing pattern shown in the guide's Testing section
@SpringBootTest
// @AutoConfigureWebMvc sets up MockMvc for web layer testing without a real server
@AutoConfigureWebMvc
public class MeControllerTest {

    // Spring injects MeController — Dependency Injection as shown in the guide
    @Autowired
    private MeController meController;

    // standaloneSetup creates a lightweight MockMvc with just our controller
    // Same pattern used in the guide's UserControllerIntegrationTest example
    private MockMvc mockMvc = standaloneSetup(meController).build();

    @Test
    public void testGetMe() throws Exception {
        // Perform GET /me and verify:
        // 1. Status is 200 OK
        // 2. Content-Type is application/json
        // 3. The "name" field exists in the JSON response
        mockMvc.perform(MockMvcRequestBuilders.get("/me"))
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$.name").exists());
    }
}