package com.costiniano.springboot;

import com.costiniano.springboot.controller.MeController;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.beans.factory.annotation.Autowired;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class MeControllerTest {

    @Autowired
    private MeController meController;

    @Test
    public void testGetMe() throws Exception {
        var response = meController.getMe();
        assertThat(response.get("name")).isEqualTo("Sean Maverick F. Costiniano");
        assertThat(response.get("studentId")).isEqualTo("2025-2022012");
    }
}