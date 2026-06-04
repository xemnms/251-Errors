package com.app.payment;

// SOLID: OCP + DIP - abstraction for all payment types
public interface Payment {
    void pay(double amount);
}