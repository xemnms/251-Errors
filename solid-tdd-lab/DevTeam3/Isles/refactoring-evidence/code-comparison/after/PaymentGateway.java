package after;

// ISP: Exposes only the operation OrderService needs.
public interface PaymentGateway {

    PaymentReceipt process(String paymentMethod, double amount);
}
