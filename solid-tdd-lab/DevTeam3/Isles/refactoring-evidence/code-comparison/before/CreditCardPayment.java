package before;

public class CreditCardPayment implements Payment {

    @Override
    public PaymentReceipt process(double amount) {
        return new PaymentReceipt("credit-card", amount, "APPROVED");
    }
}
