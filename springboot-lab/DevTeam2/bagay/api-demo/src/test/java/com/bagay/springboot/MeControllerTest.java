package com.bagay.springboot;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import com.bagay.springboot.controller.MeController;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
class MeControllerTest {

    @Autowired
    private MeController meController;

    @Test
    void testGetMe() throws Exception {
        MockMvc mockMvc = standaloneSetup(meController).build();

        mockMvc.perform(get("/me"))
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.name").value("Axel Drake M. Bagay"))
                .andExpect(jsonPath("$.studentId").value("2025-1020735"))
                .andExpect(jsonPath("$.course").value("Java Programming"))
                .andExpect(jsonPath("$.message").value("Learning Spring Boot REST APIs!"));
    }
}

