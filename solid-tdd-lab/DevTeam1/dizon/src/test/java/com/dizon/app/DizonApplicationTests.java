package com.dizon.app;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

// Integration-style smoke test: boots the full Spring context, proving every bean
// (service + injected validator/mapper/repository, payment processors) wires together.
// BONUS: integration test.
@SpringBootTest
class DizonApplicationTests {

    @Test
    void contextLoads() {
    }
}
