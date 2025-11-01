package domain;

import lotto.Lotto;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;

public final class ResultCalculator {

    private ResultCalculator() {}

    public static Map<Rank, Integer> calculate(
            final List<Lotto> tickets,
            final WinningNumbers winning,
            final BonusNumber bonus
    ) {
        Map<Rank, Integer> result = new EnumMap<>(Rank.class);
        for (Lotto lotto : tickets) {
            Rank rank = determineRank(lotto, winning, bonus);
            result.put(rank, result.getOrDefault(rank, 0) + 1);
        }
        return result;
    }

    private static Rank determineRank(
            final Lotto lotto,
            final WinningNumbers winning,
            final BonusNumber bonus
    ) {
        long matchCount = lotto.getNumbers().stream()
                .filter(winning.getNumbers()::contains)
                .count();
        boolean bonusMatched = lotto.getNumbers().contains(bonus.value());
        return Rank.of((int) matchCount, bonusMatched);
    }
}