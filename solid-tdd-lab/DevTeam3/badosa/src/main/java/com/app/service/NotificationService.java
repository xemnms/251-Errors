package com.app.service;

import com.app.entity.Employee;

// GRASP: Polymorphism — Using an interface to represent notification logic allows different notification mechanisms (Email, SMS) to be handled polymorphically.
// GRASP: Protected Variations — This interface protects clients from changes in how notifications are sent.
public interface NotificationService {
    void sendNotification(Employee employee, String message);
}
