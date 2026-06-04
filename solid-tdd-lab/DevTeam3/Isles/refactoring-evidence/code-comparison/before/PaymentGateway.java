package before;

public interface PaymentGateway {

    PaymentReceipt process(String paymentMethod, double amount);
}
