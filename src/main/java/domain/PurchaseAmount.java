package domain;

public class PurchaseAmount {
    public static final  int UNIT = 1_000;

    private  final int value;

    public PurchaseAmount(final int value) {
        vaildatePositive(value);
        vaildateUnit(value);
        this.value = value;
    }

    public static PurchaseAmount of(final int value) {
        return new PurchaseAmount(value);
    }

    public int value() {
        return value;
    }

    public int ticketCount() {
        return value / UNIT;
    }

    public void vaildatePositive(final int value) {
        if (value <= 0) {
            throw new IllegalArgumentException("[ERROR] 구입 금액은 0보다 커야 합니다.");
        }
    }

    public void vaildateUnit(final int value) {
        if (value % UNIT != 0) {
            throw new IllegalArgumentException("[ERROR] 구입 금액은 1,000원 단위여야 합니다.");
        }
    }
}
