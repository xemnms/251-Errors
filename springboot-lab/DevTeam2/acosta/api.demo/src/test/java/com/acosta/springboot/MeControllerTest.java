package com.acosta.springboot;

import com.acosta.springboot.controller.MeController;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.setup.MockMvcBuilders.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
public class MeControllerTest {

    @Autowired
    private MeController meController;

    private MockMvc mockMvc;

    @Test
    public void testGetMe() throws Exception {
        mockMvc = standaloneSetup(meController).build();

        mockMvc.perform(get("/me"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").exists());
    }
}

// I used Spring Initializr to generate the project

// @RestController tells Spring this class handles HTTP requests

// @GetMapping("/me") maps the /me URL to this method

// I changed from String to Map so Spring can return JSON

// Spring Boot automatically converts Java objects to JSON using Jackson