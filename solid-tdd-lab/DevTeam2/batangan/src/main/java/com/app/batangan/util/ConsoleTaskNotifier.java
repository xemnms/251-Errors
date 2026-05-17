package com.app.batangan.util;
import com.app.batangan. entity.Task;
import org.springframework.stereotype.Component;

// GRASP: Polymorphism - second concrete implementation
@Component("consoleNotifier")
public class ConsoleTaskNotifier implements TaskNotifier {

    @Override
    public void notify(Task task, String event) {
        System.out.println("[CONSOLE LOG] Event=" + event
            + " | Task=" + task.getTitle()
            + " | Status=" + task.getStatus());
    }
}