public class AbstractConcretePayment_Nepomuceno extends AbstractPayment_Arandela {

    public AbstractConcretePayment_Nepomuceno(String paymentType, String date, double amount) {
        super(paymentType, date, amount);
    }

    @Override
    public void processPayment() {
        // Simple example payment processing behavior
        System.out.println("Processing payment...");
        displayPayment();

        // Mark the payment as paid after "processing"
        markAsPaid();
        System.out.println("Payment Status: " + getStatus());
    }
}