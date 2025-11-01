package domain;

import java.util.Arrays;

public enum Rank {
    FIRST(6, false, 2_000_000_000),
    SECOND(5, true, 30_000_000),
    THIRD(5, false, 1_500_000),
    FOURTH(4, false, 50_000),
    FIFTH(3, false, 5_000),
    MISS(0, false, 0);

    private final int matchCount;
    private final boolean bonusRequired;
    private final int prize;

    Rank(final int matchCount, final boolean bonusRequired, final int prize) {
        this.matchCount = matchCount;
        this.bonusRequired = bonusRequired;
        this.prize = prize;
    }

    public int prize() {
        return prize;
    }

    public int matchCount() {
        return matchCount;
    }

    public static Rank of(final int matchCount, final boolean bonusMatched) {
        return Arrays.stream(values())
                .filter(rank -> rank.matchCount == matchCount)
                .filter(rank -> !rank.bonusRequired || bonusMatched)
                .findFirst()
                .orElse(MISS);
    }

    @Override
    public String toString() {
        return switch (this) {
            case FIRST -> "6개 일치 (2,000,000,000원)";
            case SECOND -> "5개 일치, 보너스 볼 일치 (30,000,000원)";
            case THIRD -> "5개 일치 (1,500,000원)";
            case FOURTH -> "4개 일치 (50,000원)";
            case FIFTH -> "3개 일치 (5,000원)";
            default -> "";
        };
    }
}