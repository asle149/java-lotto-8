package domain;

import java.util.Map;

public final class ProfitCalculator {
    private ProfitCalculator() {}

    public static double calculateRate(final Map<Rank, Integer> result, final int totalPurchaseAmount) {
        long totalPrize = result.entrySet().stream()
                .mapToLong(entry -> (long) entry.getKey().prize() * entry.getValue())
                .sum();

        double rate = (double) totalPrize / totalPurchaseAmount * 100;
        return Math.round(rate * 10) / 10.0;
    }
}