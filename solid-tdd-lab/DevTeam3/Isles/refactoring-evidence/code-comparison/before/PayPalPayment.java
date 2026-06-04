package before;

public class PayPalPayment implements Payment {

    @Override
    public PaymentReceipt process(double amount) {
        return new PaymentReceipt("paypal", amount, "APPROVED");
    }
}
