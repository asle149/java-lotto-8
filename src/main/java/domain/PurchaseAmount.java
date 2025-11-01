package domain;

public final class PurchaseAmount {
    private static final int UNIT = 1_000;
    private final int value;

    private PurchaseAmount(final int value) {
        validatePositive(value);
        validateUnit(value);
        this.value = value;
    }

    public static PurchaseAmount of(final int value) {
        return new PurchaseAmount(value);
    }

    public int ticketCount() {
        return value / UNIT;
    }

    private void validatePositive(final int value) {
        if (value <= 0) {
            throw new IllegalArgumentException("[ERROR] 구입 금액은 0보다 커야 합니다.");
        }
    }

    private void validateUnit(final int value) {
        if (value % UNIT != 0) {
            throw new IllegalArgumentException("[ERROR] 구입 금액은 1,000원 단위여야 합니다.");
        }
    }
}