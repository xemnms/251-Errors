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

@SpringBootTest
@AutoConfigureWebMvc
public class MeControllerTest {

    @Autowired
    private MeController meController;

    @Test
    public void testGetMe() throws Exception {
        // Build MockMvc manually to ensure controller is tested in isolation
        MockMvc mockMvc = standaloneSetup(meController).build();

        mockMvc.perform(MockMvcRequestBuilders.get("/me"))
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$.name").value("Andrew Dizon"))
                .andExpect(jsonPath("$.studentId").value("2025-1024539"));
    }
}