package com.app.alvarez.util;

import java.math.BigDecimal;
import java.math.RoundingMode;

public final class MoneyRounder {

    private MoneyRounder() {
    }

    public static double toCurrency(double amount) {
        return BigDecimal.valueOf(amount)
                .setScale(2, RoundingMode.HALF_UP)
                .doubleValue();
    }
}