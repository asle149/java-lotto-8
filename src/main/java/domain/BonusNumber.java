package domain;

import java.util.List;

public final class BonusNumber {
    private final int value;

    private BonusNumber(final int value) {
        this.value = value;
    }

    public static BonusNumber of(final int value, final WinningNumbers winning) {
        validateRange(value);
        validateNotDuplicated(value, winning.getNumbers());
        return new BonusNumber(value);
    }

    public int value() {
        return value;
    }

    private static void validateRange(final int value) {
        if (value < 1 || value > 45) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 1~45 범위의 숫자여야 합니다.");
        }
    }

    private static void validateNotDuplicated(final int value, final List<Integer> winning) {
        if (winning.contains(value)) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 당첨 번호와 중복될 수 없습니다.");
        }
    }
}