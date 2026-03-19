public class Payment_Arandela {
    // Private attributes
    private String paymentMethod;
    private double amount;
    private boolean isPaid;

    // Constructor
    public Payment(String paymentMethod, double amount) {
        this.paymentMethod = paymentMethod;
        setAmount(amount); // use setter for validation
        this.isPaid = false;
    }

    // Getters
    public String getPaymentMethod() {
        return paymentMethod;
    }

    public double getAmount() {
        return amount;
    }

    public boolean isPaid() {
        return isPaid;
    }

    // Setters with validation
    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public void setAmount(double amount) {
        if (amount > 0) {
            this.amount = amount;
        } else {
            System.out.println("Invalid amount. Must be greater than 0.");
        }
    }

    // Behaviors (methods)
    public void processPayment() {
        if (amount > 0) {
            isPaid = true;
            System.out.println("Payment successful!");
        } else {
            System.out.println("Payment failed. Invalid amount.");
        }
    }

    public void displayPaymentDetails() {
        System.out.println("Payment Method: " + paymentMethod);
        System.out.println("Amount: " + amount);
        System.out.println("Status: " + (isPaid ? "Paid" : "Unpaid"));
    }
}
