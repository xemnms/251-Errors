package org.junit.jupiter.api;

public class Assertions {
    public static void assertNotNull(Object actual, String message) {
        if (actual == null) {
            throw new AssertionError(message);
        }
    }

    public static void assertTrue(boolean condition, String message) {
        if (!condition) {
            throw new AssertionError(message);
        }
    }

    public static void assertEquals(Object expected, Object actual, String message) {
        if ((expected == null && actual != null) || (expected != null && !expected.equals(actual))) {
            throw new AssertionError(message + ". Expected: " + expected + ", but was: " + actual);
        }
    }
}

