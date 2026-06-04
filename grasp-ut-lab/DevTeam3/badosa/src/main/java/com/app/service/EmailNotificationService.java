package com.app.service;

import com.app.entity.Employee;
import org.springframework.stereotype.Service;

// GRASP: High Cohesion — This class has a single, cohesive responsibility: handling email notifications.
@Service("emailNotificationService")
public class EmailNotificationService implements NotificationService {

    @Override
    public void sendNotification(Employee employee, String message) {
        // Mock email sending
        System.out.println("Sending Email to " + employee.getEmail() + ": " + message);
    }
}
