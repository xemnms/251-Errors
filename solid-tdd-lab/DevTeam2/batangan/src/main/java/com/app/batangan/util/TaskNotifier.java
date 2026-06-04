package com.app.batangan.util;

import com.app.batangan.entity.Task;

// GRASP: Polymorphism - define behavior as interface
// GRASP: Protected Variations - swap implementations without changing callers
// GRASP: Low Coupling - callers depend on this interface, not concrete class
public interface TaskNotifier {
    void notify(Task task, String event);
}