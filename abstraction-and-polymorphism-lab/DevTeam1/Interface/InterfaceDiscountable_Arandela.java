public interface InterfaceDiscountable_Arandela {

    // ABSTRACT METHOD
    void processPayment();
    double applyDiscount(double amount);

    // DEFAULT METHOD
    default void discountNotice() {
        System.out.println("Discount applied.");
    }
}