package com.app.batangan.util;
import org.springframework.stereotype.Component;

import com.app.batangan.entity.Task;

// GRASP: Polymorphism - one concrete implementation
@Component("emailNotifier")
public class EmailTaskNotifier implements TaskNotifier {

    @Override
    public void notify(Task task, String event) {
        // In real life: send an email. Here we just print.
        System.out.println("[EMAIL] Task '" + task.getTitle()
            + "' event: " + event
            + " | Assigned to: " + task.getAssignedTo());
    }
}