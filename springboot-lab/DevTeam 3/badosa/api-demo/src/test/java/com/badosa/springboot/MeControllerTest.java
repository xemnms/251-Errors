package com.badosa.springboot;

import com.badosa.springboot.controller.MeController;
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
        assertThat(response.get("name")).isEqualTo("Bien Manuel P. Badosa");
        assertThat(response.get("studentId")).isEqualTo("2025-1021747");
    }
}
