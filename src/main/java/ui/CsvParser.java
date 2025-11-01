package ui;

import java.util.ArrayList;
import java.util.List;

public final class CsvParser {
    private CsvParser() {}

    public static List<Integer> parseCsvToInts(final String raw) {
        if (raw == null) {
            throw new IllegalArgumentException("[ERROR] 숫자를 입력해 주세요.");
        }
        final String[] tokens = raw.split(",");
        final List<Integer> result = new ArrayList<>(tokens.length);
        for (String token : tokens) {
            final String t = token.trim();
            if (t.isEmpty()) {
                throw new IllegalArgumentException("[ERROR] 숫자를 입력해 주세요.");
            }
            result.add(parseIntStrict(t));
        }
        return result;
    }

    private static int parseIntStrict(final String s) {
        try {
            return Integer.parseInt(s);
        } catch (NumberFormatException ex) {
            throw new IllegalArgumentException("[ERROR] 숫자를 입력해 주세요.");
        }
    }
}