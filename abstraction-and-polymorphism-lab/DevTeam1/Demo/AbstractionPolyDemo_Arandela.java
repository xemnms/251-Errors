public class AbstractionPolyDemo_Arandela {

    public static void main(String[] args) {

        // DYNAMIC BINDING (ABSTRACT)
        AbstractVehicle_Galindon vehicle =
                new AbstractConcreteVehicle_Arandela("Toyota Supra", 0, 300);

        vehicle.showInfo();
        vehicle.stop(); // overridden method


        // METHOD OVERLOADING
        AbstractConcreteVehicle_Arandela car =
                new AbstractConcreteVehicle_Arandela("Honda Civic", 0, 220);

        car.accelerate(30);
        car.accelerate(30, "sport"); // overloaded


        // =========================
        // DYNAMIC BINDING (INTERFACE)
        // =========================
        InterfaceNotifier_Nepomuceno notifier =
                new InterfaceConcreteNotifier_Arandela("Vehicle is running");

        notifier.sendNotification();
        notifier.displayNotification();
        notifier.markAsRead();
        notifier.defaultNotification(); // default method
    }
}

/*
========================= ANALYSIS =========================

Abstract class used:
- AbstractVehicle_Galindon

Interface used:
- InterfaceNotifier_Nepomuceno

Concrete classes used:
- AbstractConcreteVehicle_Arandela
- InterfaceConcreteNotifier_Arandela

Methods overridden:
- stop() in AbstractConcreteVehicle_Arandela
- sendNotification(), displayNotification(), markAsRead(), getReadStatus()
  in InterfaceConcreteNotifier_Arandela

Methods overloaded:
- accelerate(double)
- accelerate(double, String)

Dynamic binding:
- AbstractVehicle_Galindon vehicle = new AbstractConcreteVehicle_Arandela(...)
- InterfaceNotifier_Nepomuceno notifier = new InterfaceConcreteNotifier_Arandela(...)

Polymorphism:
- Same method calls behave differently based on object type

Low coupling:
- Uses abstraction (abstract class + interface)

High cohesion:
- Each class has a focused responsibility

===========================================================
*/