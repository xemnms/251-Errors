public class AbstractConcreteNotifier_Galindon extends AbstractNotifier_Nepomuceno {

    // Constructor with message
    public AbstractConcreteNotifier_Galindon(String appName, String date, String message) {
        super(appName, date, message);
    }

    // Overloaded constructor (default message)
    public AbstractConcreteNotifier_Galindon(String appName, String date) {
        super(appName, date);
    }

    // Overriding
    @Override
    public void sendNotification() {
        System.out.println("App Notification Sent!");
        displayNotification();
    }

    // Overloading
    public void sendNotification(int repeatCount) {
        for (int i = 1; i <= repeatCount; i++) {
            System.out.println("Sending notification #" + i);
            displayNotification();
        }
    }
}