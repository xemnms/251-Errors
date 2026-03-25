public interface InterfaceDiscountable_Arandela {

    void processPayment(); // 
    double applyDiscount(double amount);

    default void discountNotice() {
        System.out.println("Discount applied to your payment.\n");
    }
}