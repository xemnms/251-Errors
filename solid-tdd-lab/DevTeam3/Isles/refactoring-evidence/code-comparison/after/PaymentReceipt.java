package after;

public record PaymentReceipt(
        String provider,
        double amount,
        String status
) {
}
