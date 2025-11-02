package ui;

import domain.Rank;
import lotto.Lotto;

import java.util.List;
import java.util.Map;

public final class OutputView {
    private OutputView() {}

    public static void printBlankLine() {
        System.out.println();
    }

    public static void printPurchasedCount(final int count) {
        System.out.println(count + "개를 구매했습니다.");
    }

    public static void printTickets(final List<Lotto> tickets) {
        for (Lotto lotto : tickets) {
            System.out.println(lotto);
        }
        printBlankLine();
    }

    public static void printError(final String message) {
        System.out.println(message);
    }

    public static void printResult(final Map<Rank, Integer> result) {
        printBlankLine();
        System.out.println("당첨 통계");
        System.out.println("---");

        Rank[] order = { Rank.FIFTH, Rank.FOURTH, Rank.THIRD, Rank.SECOND, Rank.FIRST };
        for (Rank rank : order) {
            int count = result.getOrDefault(rank, 0);
            System.out.printf("%s - %d개%n", rank.toString(), count);
        }
    }

    public static void printProfitRate(final double rate) {
        System.out.printf("총 수익률은 %.1f%%입니다.%n", rate);
    }
}