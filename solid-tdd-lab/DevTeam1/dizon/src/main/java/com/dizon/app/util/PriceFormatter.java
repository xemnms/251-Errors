package com.dizon.app.util;

// OOP: KISS + DRY - one tiny utility for money rounding, reused by the mapper.
// SOLID: SRP - rounds money, nothing else.
public final class PriceFormatter {

    // YAGNI: deliberately NO currency-symbol / locale formatting here. Nothing in the
    // system needs it yet, so it is not built. It can be added the day a requirement exists.
    private PriceFormatter() {
        // utility class - no instances
    }

    // DRY: shared reusable rounding logic (2 decimal places, half-up via Math.round).
    public static double round(double amount) {
        return Math.round(amount * 100.0) / 100.0;
    }
}
