package com.bautista.grasp.entity;

/*
 * GRASP: Polymorphism
 * GRASP: Protected Variations (different payment types interchangeable)
 */
public interface Payment {
    String process(double amount);
}