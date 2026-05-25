package com.nepomuceno.app.util;

// GRASP: Pure Fabrication — not a real-world concept; created to keep formatting logic DRY
// GRASP: High Cohesion — only handles price formatting, nothing else
public class PriceFormatter {

    private PriceFormatter() {
        // Utility class — no instances needed
    }

    public static String format(double amount) {
        return String.format("PHP %.2f", amount);
    }

    public static String formatUSD(double amount) {
        return String.format("$%.2f", amount);
    }
}