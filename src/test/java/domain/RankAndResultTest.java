package domain;

import lotto.Lotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.*;

class RankAndResultTest {

    @Test
    @DisplayName("일치 개수와 보너스 여부로 등수를 판정한다.")
    void rankDecision() {
        assertThat(Rank.of(6, false)).isEqualTo(Rank.FIRST);
        assertThat(Rank.of(5, true)).isEqualTo(Rank.SECOND);
        assertThat(Rank.of(5, false)).isEqualTo(Rank.THIRD);
        assertThat(Rank.of(4, false)).isEqualTo(Rank.FOURTH);
        assertThat(Rank.of(3, false)).isEqualTo(Rank.FIFTH);
        assertThat(Rank.of(2, false)).isEqualTo(Rank.MISS);
    }

    @Test
    @DisplayName("로또 목록으로부터 각 등수별 개수를 계산한다.")
    void resultCalculation() {
        List<Lotto> tickets = List.of(
                new Lotto(List.of(1, 2, 3, 4, 5, 6)),
                new Lotto(List.of(1, 2, 3, 4, 5, 7))
        );

        WinningNumbers winning = new WinningNumbers(List.of(1, 2, 3, 4, 5, 6));
        BonusNumber bonus = BonusNumber.of(7, winning);

        Map<Rank, Integer> result = ResultCalculator.calculate(tickets, winning, bonus);

        assertThat(result.get(Rank.FIRST)).isEqualTo(1);
        assertThat(result.get(Rank.SECOND)).isEqualTo(1);
    }
}