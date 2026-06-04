package after;

public interface Payment {

    // OCP: New payment methods add a new implementation instead of changing PaymentProcessor.
    String method();

    PaymentReceipt process(double amount);
}
