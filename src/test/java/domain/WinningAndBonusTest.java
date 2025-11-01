package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

class WinningAndBonusTest {

    @Test
    @DisplayName("당첨 번호가 6개일 때 정상 생성된다.")
    void validWinningNumbers() {
        assertThatCode(() -> new WinningNumbers(List.of(1, 2, 3, 4, 5, 6)))
                .doesNotThrowAnyException();
    }

    @Test
    @DisplayName("당첨 번호에 중복이 있으면 예외가 발생한다.")
    void duplicatedWinningNumbers() {
        assertThatThrownBy(() -> new WinningNumbers(List.of(1, 2, 3, 3, 4, 5)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageStartingWith("[ERROR]");
    }

    @Test
    @DisplayName("보너스 번호가 1~45 범위를 벗어나면 예외가 발생한다.")
    void invalidBonusRange() {
        WinningNumbers winning = new WinningNumbers(List.of(1, 2, 3, 4, 5, 6));
        assertThatThrownBy(() -> BonusNumber.of(46, winning))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageStartingWith("[ERROR]");
    }

    @Test
    @DisplayName("보너스 번호가 당첨 번호와 중복되면 예외가 발생한다.")
    void duplicatedBonusNumber() {
        WinningNumbers winning = new WinningNumbers(List.of(1, 2, 3, 4, 5, 6));
        assertThatThrownBy(() -> BonusNumber.of(6, winning))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageStartingWith("[ERROR]");
    }
}