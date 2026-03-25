public class AbstractionPolyDemo_Galindon {
    public static void main(String[] args) {

        // Dynamic Binding & Overriding
        AbstractNotifier_Nepomuceno notif1 = 
            new AbstractConcreteNotifier_Galindon("WhatsApp", "2026-03-25", "New voice message!");
        AbstractNotifier_Nepomuceno notif2 = 
            new AbstractConcreteNotifier_Galindon("Slack", "2026-03-25");

        // Overriding 
        notif1.sendNotification();
        notif2.sendNotification();

        // Overloading 
        AbstractConcreteNotifier_Galindon concreteNotif = 
            new AbstractConcreteNotifier_Galindon("Telegram", "2026-03-25", "New sticker received!");
        concreteNotif.sendNotification(3);  // Overloaded method

        InterfaceDiscountable_Arandela pay1 = 
            new InterfaceConcreteDiscountable_Galindon(750);
        InterfaceDiscountable_Arandela pay2 = 
            new InterfaceConcreteDiscountable_Galindon(1500);

        // Overriding demonstrated
        pay1.processPayment();
        pay2.processPayment();

        // Overloading
        InterfaceConcreteDiscountable_Galindon concretePay = 
            new InterfaceConcreteDiscountable_Galindon(2000);
        double discounted = concretePay.applyDiscount(2000, 0.25);  // Overloaded method
        System.out.println("Custom Discounted Amount: " + discounted);
    }
}


/*

1. Abstract class
    AbstractNotifier_Nepomuceno
2. Interface
    InterfaceDiscountable_Arandela
3. Overridden methods
    sendNotification(), processPayment(), applyDiscount(double)
4. Overloaded methods
    sendNotification(int), applyDiscount(double, double)
5. Dynamic binding
    When abstract/interface references call methods on concrete objects
6. Polymorphism
    Same reference type used for different objects
7. Low coupling
    Classes use abstract/interface references instead of concrete classes
8. High cohesion
    Each class has a clear job and related methods together

    */
