package ui;

public final class NumberParser {
    private NumberParser() {}

    public static int parsePositiveInt(final String raw) {
        try {
            final int n = Integer.parseInt(raw.trim());
            if (n <= 0) {
                throw new IllegalArgumentException("[ERROR] 구입 금액은 0보다 커야 합니다.");
            }
            return n;
        } catch (NumberFormatException ex) {
            throw new IllegalArgumentException("[ERROR] 숫자를 입력해 주세요.");
        }
    }
}