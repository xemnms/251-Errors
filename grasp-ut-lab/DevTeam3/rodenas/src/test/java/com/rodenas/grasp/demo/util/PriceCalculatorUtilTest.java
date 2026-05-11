package com.rodenas.grasp.demo.util;

import com.rodenas.grasp.demo.entity.Order;
import com.rodenas.grasp.demo.entity.OrderItem;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PriceCalculatorUtilTest {

    private PriceCalculatorUtil calculator;

    @BeforeEach
    void setUp() {
        calculator = new PriceCalculatorUtil();
    }

    @Test
    void shouldCalculateVatCorrectly() {
        assertEquals(12.0, calculator.calculateVat(100.0));
    }

    @Test
    void shouldApplySeniorDiscount() {
        assertEquals(80.0, calculator.calculateFinalTotal(100.0, true));
    }

    @Test
    void shouldNotApplyDiscountForNonSenior() {
        assertEquals(100.0, calculator.calculateFinalTotal(100.0, false));
    }

    @Test
    void shouldCalculateTotalWithVat() {
        Order order = new Order("Kyla", "CASH");
        order.addItem(new OrderItem("KayBurger", 100.0, 1));
        assertEquals(112.0, calculator.calculateTotalWithVat(order));
    }
}