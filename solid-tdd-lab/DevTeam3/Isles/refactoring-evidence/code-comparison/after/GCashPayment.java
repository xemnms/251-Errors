package after;

public class GCashPayment implements Payment {

    @Override
    public String method() {
        return "GCASH";
    }

    @Override
    public PaymentReceipt process(double amount) {
        return new PaymentReceipt("gcash", amount, "APPROVED");
    }
}
