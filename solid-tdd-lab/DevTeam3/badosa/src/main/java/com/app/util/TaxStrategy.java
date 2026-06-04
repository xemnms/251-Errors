package com.app.util;

// SOLID: OCP — The TaxStrategy interface defines a contract for calculating taxes, allowing new tax algorithms to be added without modifying the clients.
// SOLID: DIP — Clients depend on this interface abstraction rather than a concrete implementation class.
public interface TaxStrategy {
    
    double calculateTax(double salary);
}
