package com.nepomuceno.app.util;

// GRASP: Pure Fabrication - not a real-world concept; exists to keep formatting DRY
// GRASP: High Cohesion - only handles price formatting, nothing else
// OOP: YAGNI applied
//
// BEFORE (had an unused formatUSD method):
//   public static String formatUSD(double amount) {
//       return String.format("$%.2f", amount);
//   }
//
// AFTER (removed formatUSD):
//   Only the method actually used in the system is kept.
//
// WHY: formatUSD was never called anywhere in the codebase.
// YAGNI (You Aren't Gonna Need It) tells us not to keep code
// for hypothetical future use — it adds noise, misleads readers,
// and must be maintained for no benefit. If USD support is needed
// later, it can be added then.
public class PriceFormatter {

    private PriceFormatter() {
        // Utility class — no instances needed
    }

    // DRY: Single place to change the currency format across the whole app
    public static String format(double amount) {
        return String.format("PHP %.2f", amount);
    }
}
