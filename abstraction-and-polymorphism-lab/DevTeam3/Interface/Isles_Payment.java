//Isles_Payment class by Dan Isles
//this class demonstrates simple payment
public interface Isles_Payment {
 
	//abstract methods
	boolean processPayment(double amount);
 
	//get the current balance or payment status
	double getBalance();
 
	//refund a specified amount to the customer
	boolean refund(double amount);
 
	//validates if payment method is valid
	boolean validatePaymentMethod();
 
	//gets payment method type
	String getPaymentMethodType();
 
	//default methods displays the customer with a thank you message
	default void thankCustomer() {
    System.out.println("Thank you for shopping with Isles!");
}
}
