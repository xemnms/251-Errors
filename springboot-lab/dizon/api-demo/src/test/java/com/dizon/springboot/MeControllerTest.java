package com.dizon.springboot;

import com.dizon.springboot.controller.MeController;
import org.junit.jupiter.api.BeforeEach; // Add this import
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.*;

@SpringBootTest
public class MeControllerTest {

    @Autowired
    private MeController meController;

    private MockMvc mockMvc;

    @BeforeEach
    public void setup() {
        // This ensures meController is NOT null when building MockMvc
        this.mockMvc = standaloneSetup(meController).build();
    }

    @Test
    public void testGetMe() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/me"))
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$.name").exists());
    }
}