package domain;

import java.util.Collections;
import java.util.List;

public final class WinningNumbers {
    private final List<Integer> numbers; // 정렬된 불변 리스트(6개)

    public WinningNumbers(final List<Integer> numbers) {
        validate(numbers);
        numbers.sort(Integer::compareTo);
        this.numbers = List.copyOf(numbers);
    }

    private void validate(final List<Integer> numbers) {
        if (numbers == null || numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호는 6개여야 합니다.");
        }
        final long distinct = numbers.stream().distinct().count();
        if (distinct != 6) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호는 중복될 수 없습니다.");
        }
        final boolean outOfRange = numbers.stream().anyMatch(n -> n < 1 || n > 45);
        if (outOfRange) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호는 1~45 범위의 숫자여야 합니다.");
        }
    }

    public List<Integer> getNumbers() {
        return Collections.unmodifiableList(numbers);
    }
}