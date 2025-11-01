package domain;

import java.util.List;
import java.util.stream.Collectors;

public final class WinningNumbers {
    private static final int SIZE = 6;
    private static final int MIN = 1;
    private static final int MAX = 45;

    private final List<Integer> numbers;

    public WinningNumbers(final List<Integer> numbers) {
        validate(numbers);

        this.numbers = numbers.stream()
                .sorted()
                .collect(Collectors.toList());
    }

    private void validate(final List<Integer> numbers) {
        if (numbers.size() != SIZE) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호는 6개여야 합니다.");
        }
        if (numbers.stream().distinct().count() != SIZE) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호는 중복될 수 없습니다.");
        }
        final boolean outOfRange = numbers.stream().anyMatch(n -> n < MIN || n > MAX);
        if (outOfRange) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호는 1~45 범위여야 합니다.");
        }
    }

    public List<Integer> getNumbers() {

        return List.copyOf(numbers);
    }

    public boolean contains(final int value) {
        return numbers.contains(value);
    }

    public int matchCount(final List<Integer> ticketNumbers) {

        return (int) ticketNumbers.stream().filter(numbers::contains).count();
    }
}