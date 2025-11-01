package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class PurchaseAmountTest {

    @Test
    @DisplayName("금액이 1,000원 단위이면 티켓 개수를 계산한다.")
    void calculateTicketCount() {
        PurchaseAmount amount = PurchaseAmount.of(8000);
        assertThat(amount.ticketCount()).isEqualTo(8);
    }

    @Test
    @DisplayName("금액이 0 이하이면 예외가 발생한다.")
    void validatePositive() {
        assertThatThrownBy(() -> PurchaseAmount.of(0))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageStartingWith("[ERROR]");
    }

    @Test
    @DisplayName("금액이 1,000원 단위가 아니면 예외가 발생한다.")
    void validateUnit() {
        assertThatThrownBy(() -> PurchaseAmount.of(1500))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageStartingWith("[ERROR]");
    }
}