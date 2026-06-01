package com.alonde.app.payment;

import com.alonde.app.exception.InvalidPaymentTypeException;
import org.junit.jupiter.api.Test;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

class PaymentProcessorTest {

    // test: each processor reports its own type correctly

    @Test
    void eachProcessorHasCorrectType() {
        assertThat(new CreditCardPaymentProcessor().getType()).isEqualTo("CREDIT_CARD");
        assertThat(new CashPaymentProcessor().getType()).isEqualTo("CASH");
        assertThat(new GCashPaymentProcessor().getType()).isEqualTo("GCASH");
    }

    // test: factory routes to correct processor

    @Test
    void factoryResolvesCorrectProcessor() {
        PaymentProcessorFactory factory = new PaymentProcessorFactory(List.of(
                new CashPaymentProcessor(),
                new CreditCardPaymentProcessor(),
                new GCashPaymentProcessor()
        ));

        assertThat(factory.getProcessor("CASH")).isInstanceOf(CashPaymentProcessor.class);
        assertThat(factory.getProcessor("GCASH")).isInstanceOf(GCashPaymentProcessor.class);
    }

    // test: unknown payment type throws exception

    @Test
    void factoryThrowsForUnknownType() {
        PaymentProcessorFactory factory = new PaymentProcessorFactory(
                List.of(new CashPaymentProcessor())
        );
        assertThatThrownBy(() -> factory.getProcessor("BITCOIN"))
                .isInstanceOf(InvalidPaymentTypeException.class);
    }

    // test: all processors implement the same interface (polymorphism proof)

    @Test
    void allProcessorsImplementInterface() {
        List<PaymentProcessor> processors = List.of(
                new CreditCardPaymentProcessor(),
                new CashPaymentProcessor(),
                new GCashPaymentProcessor()
        );

        // none of these should throw - each implements process()
        processors.forEach(p -> assertThatNoException().isThrownBy(
                () -> p.process(100.0)
        ));
    }
}