package ui;

public class NumberParser {
    private NumberParser() {}

    public static parsePositvieInt(final String law) {
        try {
            final int n = Integer.parseInt(law.trim());
            if (n <= 0) {
                throw new IllegalArgumentException("[ERROR] 구입 금액은 0보다 커야 합니다.");
            }
            return n;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 숫자를 입력해 주세요.");
        }

    }

}
