package com.dizon.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * SOLID + OOP Best Practices Unit Testing Lab — Vic Andrew A. Dizon
 *
 * This project is the SOLID refactor of my previous GRASP + Unit Testing lab
 * (an Order Management System). The full BEFORE/AFTER analysis lives in README.md
 * and the refactoring-evidence/ folder.
 */
@SpringBootApplication
public class DizonApplication {
    public static void main(String[] args) {
        SpringApplication.run(DizonApplication.class, args);
    }
}
