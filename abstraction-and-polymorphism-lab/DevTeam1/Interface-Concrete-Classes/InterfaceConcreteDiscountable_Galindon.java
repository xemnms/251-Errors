public class InterfaceConcreteDiscountable_Galindon implements InterfaceDiscountable_Arandela {

    private double amount;

    public InterfaceConcreteDiscountable_Galindon(double amount) {
        this.amount = amount;
    }

    // ✅ Method Overriding
    @Override
    public void processPayment() {
        double finalAmount = applyDiscount(amount);
        System.out.println("Processing CASH payment...");
        System.out.println("Amount to pay: " + finalAmount);
        discountNotice();
    }

    // ✅ Method Overriding
    @Override
    public double applyDiscount(double amount) {
        return amount * 0.95; // 5% discount
    }

    // ✅ Method Overloading
    public double applyDiscount(double amount, double discountRate) {
        return amount * (1 - discountRate);
    }
}