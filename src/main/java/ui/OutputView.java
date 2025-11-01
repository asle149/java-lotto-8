package ui;

import lotto.Lotto;
import java.util.List;

public final class OutputView {
    private OutputView() {}

    public static void printPurchasedCount(final int count) {
        System.out.println(count + "개를 구매했습니다.");
    }

    public static void printTickets(final List<Lotto> tickets) {
        for (Lotto lotto : tickets) {
            System.out.println(lotto);
        }
    }

    public static void printError(final String message) {
        System.out.println(message);
    }
}