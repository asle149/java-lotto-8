package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.EnumMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.*;

class ProfitCalculatorTest {

    @Test
    @DisplayName("총 수익률을 소수점 둘째 자리에서 반올림해 계산한다.")
    void calculateProfitRate() {
        Map<Rank, Integer> result = new EnumMap<>(Rank.class);
        result.put(Rank.FIFTH, 1);

        double rate = ProfitCalculator.calculateRate(result, 8000);

        assertThat(rate).isEqualTo(62.5);
    }
}