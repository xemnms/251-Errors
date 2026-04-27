package com.bautista.springboot;

import com.bautista.springboot.controller.MeController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class MeControllerTest {

    @Autowired
    private MeController meController;

    @Test
    public void testGetMe() {

        var response = meController.getMe();

        assertThat(response.get("name")).isEqualTo("Lei Bautista");
        assertThat(response.get("studentId")).isEqualTo("2025-1028356");
    }
}