package com.acosta.springboot.service;

import com.acosta.springboot.entity.Order;
import com.acosta.springboot.entity.OrderItem;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

// SOLID: OCP  - Tests prove new payment types work without modifying core logic
// SOLID: LSP  - Both processors are tested against the same PaymentProcessor interface
// GRASP: Polymorphism - Same interface, different behaviors
class PaymentProcessorTest {

    // =========================================================
    // TEST 1: Cash payment sets status to COMPLETED
    // =========================================================
    @Test
    void cashPaymentShouldSetStatusToCompleted() {
        // SOLID: LSP - CashPaymentProcessor used as PaymentProcessor
        PaymentProcessor processor = new CashPaymentProcessor();

        Order order = new Order("Juan");
        order.addItem(new OrderItem("Burger", 99.0, 2));

        processor.process(order);

        assertEquals("COMPLETED", order.getStatus());
    }

    // =========================================================
    // TEST 2: GCash payment sets status to COMPLETED
    // =========================================================
    @Test
    void gcashPaymentShouldSetStatusToCompleted() {
        // SOLID: LSP - GCashPaymentProcessor used as PaymentProcessor
        // This will go RED because GCashPaymentProcessor doesn't exist yet
        PaymentProcessor processor = new GCashPaymentProcessor();

        Order order = new Order("Maria");
        order.addItem(new OrderItem("Pizza", 150.0, 1));

        processor.process(order);

        assertEquals("COMPLETED", order.getStatus());
    }

    // =========================================================
    // TEST 3: Both processors satisfy the same contract (LSP proof)
    // =========================================================
    @Test
    void bothProcessorsShouldCompleteOrderRegardlessOfType() {
        // SOLID: LSP - system works correctly with ANY PaymentProcessor
        PaymentProcessor[] processors = {
                new CashPaymentProcessor(),
                new GCashPaymentProcessor() // RED until we create this
        };

        for (PaymentProcessor processor : processors) {
            Order order = new Order("Test Customer");
            order.addItem(new OrderItem("Item", 50.0, 1));

            processor.process(order);

            // Every processor MUST set status to COMPLETED — LSP guarantee
            assertEquals("COMPLETED", order.getStatus(),
                    "Processor " + processor.getClass().getSimpleName() +
                            " failed to complete the order");
        }
    }

    // =========================================================
    // TEST 4: Factory returns correct processor for CASH
    // =========================================================
    @Test
    void factoryShouldReturnCashProcessor() {
        CashPaymentProcessor cash = new CashPaymentProcessor();
        GCashPaymentProcessor gcash = new GCashPaymentProcessor();
        PaymentProcessorFactory factory = new PaymentProcessorFactoryImpl(cash, gcash); // changed

        PaymentProcessor processor = factory.getProcessor("CASH");
        assertInstanceOf(CashPaymentProcessor.class, processor);
    }

    // =========================================================
    // TEST 5: Factory returns correct processor for GCASH
    // =========================================================
    @Test
    void factoryShouldReturnGCashProcessor() {
        CashPaymentProcessor cash = new CashPaymentProcessor();
        GCashPaymentProcessor gcash = new GCashPaymentProcessor();
        PaymentProcessorFactory factory = new PaymentProcessorFactoryImpl(cash, gcash); // changed

        PaymentProcessor processor = factory.getProcessor("GCASH");
        assertInstanceOf(GCashPaymentProcessor.class, processor);
    }

    // =========================================================
    // TEST 6: Factory throws exception for unknown payment type
    // =========================================================
    @Test
    void factoryShouldThrowForUnknownPaymentMethod() {
        CashPaymentProcessor cash = new CashPaymentProcessor();
        GCashPaymentProcessor gcash = new GCashPaymentProcessor();
        PaymentProcessorFactory factory = new PaymentProcessorFactoryImpl(cash, gcash); // changed

        assertThrows(IllegalArgumentException.class, () -> {
            factory.getProcessor("BITCOIN");
        });
    }
}