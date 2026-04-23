package com.bagay.springboot;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
@AutoConfigureMockMvc
class MeControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void testGetMe() throws Exception {
        mockMvc.perform(get("/me"))
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.name").value("Axel Drake M. Bagay"))
                .andExpect(jsonPath("$.studentId").value("2025-1020735"))
                .andExpect(jsonPath("$.course").value("Java Programming"))
                .andExpect(jsonPath("$.message").value("Learning Spring Boot REST APIs!"));
    }
}

