package com.app.service;

import com.app.entity.Employee;
import org.springframework.stereotype.Service;

// GRASP: High Cohesion — This class has a single, cohesive responsibility: handling SMS notifications.
@Service("smsNotificationService")
public class SmsNotificationService implements NotificationService {

    @Override
    public void sendNotification(Employee employee, String message) {
        // Mock SMS sending
        System.out.println("Sending SMS to " + employee.getName() + " (Mock Carrier): " + message);
    }
}
