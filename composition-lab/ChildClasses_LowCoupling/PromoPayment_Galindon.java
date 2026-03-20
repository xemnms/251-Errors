public class PromoPayment_Galindon extends Payment_Arandela {
    private String promoCode; // e.g., "VALORANT10"

    // Constructor
    public PromoPayment_Galindon(String paymentMethod, double amount, String promoCode) {
        super(paymentMethod, amount); // call parent constructor
        this.promoCode = promoCode;
    }

    // Getter & Setter
    public String getPromoCode() {
        return promoCode;
    }

    public void setPromoCode(String promoCode) {
        this.promoCode = promoCode;
    }

    // Overridden behavior
    @Override
    public void processPayment() {
        double finalAmount = getAmount();

        // Simple promo logic: VALORANT10 = 10% off
        if (promoCode != null && promoCode.equalsIgnoreCase("VALORANT10")) {
            finalAmount = getAmount() * 0.9;
            System.out.println("Promo applied: " + promoCode);
        } else if (promoCode != null) {
            System.out.println("Promo code invalid: " + promoCode);
        }

        if (finalAmount > 0) {
            System.out.println("Original Amount: " + getAmount());
            System.out.println("Final Amount after promo: " + finalAmount);
            System.out.println("Payment successful!");
        } else {
            System.out.println("Payment failed. Invalid amount.");
        }
    }
}