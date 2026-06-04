package com.app.batangan.util;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import org.junit.jupiter.api.Test;

import com.app.batangan.entity.Task;

// SOLID: LSP proof — both implementations substitute for TaskNotifier
// SOLID: OCP proof — system works with either without core changes
class TaskNotifierPolymorphismTest {

    private Task makeTask(String title, String status) {
        Task t = new Task();
        t.setTitle(title);
        t.setStatus(status);
        t.setAssignedTo("Alice");
        return t;
    }

    // TEST 1: LSP — EmailTaskNotifier substitutes for TaskNotifier
    @Test
    void emailNotifierSubstitutesInterface() {
        TaskNotifier notifier = new EmailTaskNotifier();
        Task task = makeTask("Email test", "PENDING");
        assertDoesNotThrow(() -> notifier.notify(task, "CREATED"));
    }

    // TEST 2: LSP — ConsoleTaskNotifier substitutes for TaskNotifier
    @Test
    void consoleNotifierSubstitutesInterface() {
        TaskNotifier notifier = new ConsoleTaskNotifier();
        Task task = makeTask("Console test", "DONE");
        assertDoesNotThrow(() -> notifier.notify(task, "DELETED"));
    }

    // TEST 3: OCP — swapping implementations doesn't break caller
    @Test
    void callerWorksWithEitherImplementation() {
        Task task = makeTask("Any task", "PENDING");

        // same caller code, different implementations
        TaskNotifier email = new EmailTaskNotifier();
        TaskNotifier console = new ConsoleTaskNotifier();

        assertDoesNotThrow(() -> email.notify(task, "CREATED"));
        assertDoesNotThrow(() -> console.notify(task, "CREATED"));
    }
}
