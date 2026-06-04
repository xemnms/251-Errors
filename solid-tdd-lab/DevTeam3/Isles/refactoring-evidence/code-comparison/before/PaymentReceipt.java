package before;

public record PaymentReceipt(
        String provider,
        double amount,
        String status
) {
}
