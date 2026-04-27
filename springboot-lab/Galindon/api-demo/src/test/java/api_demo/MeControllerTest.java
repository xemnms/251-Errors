package com.galindon.springboot.api_demo;

import com.galindon.springboot.api_demo.controller.MeController;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.*;

@SpringBootTest
public class MeControllerTest {

    private MeController meController = new MeController();
    private MockMvc mockMvc = standaloneSetup(meController).build();

    @Test
    public void testGetMe() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/me"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").exists());
    }
}