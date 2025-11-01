package lotto;

import domain.*;
import ui.*;

import java.util.List;
import java.util.Map;

public class Application {

    public static void main(String[] args) {
        int count = readPurchaseCountWithRetry();
        int purchaseAmount = count * 1000; // 구입 금액 계산

        List<Lotto> tickets = LottoMachine.publish(count);
        OutputView.printPurchasedCount(count);
        OutputView.printTickets(tickets);

        WinningNumbers winning = readWinningNumbersWithRetry();
        BonusNumber bonus = readBonusNumberWithRetry(winning);

        Map<Rank, Integer> result = ResultCalculator.calculate(tickets, winning, bonus);
        OutputView.printResult(result);

        double profitRate = ProfitCalculator.calculateRate(result, purchaseAmount);
        OutputView.printProfitRate(profitRate);
    }

    private static int readPurchaseCountWithRetry() {
        while (true) {
            try {
                String raw = InputView.readPurchaseAmountRaw();
                int value = NumberParser.parsePositiveInt(raw);
                return PurchaseAmount.of(value).ticketCount();
            } catch (IllegalArgumentException e) {
                OutputView.printError(e.getMessage());
            }
        }
    }

    private static WinningNumbers readWinningNumbersWithRetry() {
        while (true) {
            try {
                String raw = InputView.readWinningNumbersRaw();
                List<Integer> nums = CsvParser.parseCsvToInts(raw);
                return new WinningNumbers(nums);
            } catch (IllegalArgumentException e) {
                OutputView.printError(e.getMessage());
            }
        }
    }

    private static BonusNumber readBonusNumberWithRetry(final WinningNumbers winning) {
        while (true) {
            try {
                String raw = InputView.readBonusNumberRaw();
                int n = NumberParser.parsePositiveInt(raw);
                return BonusNumber.of(n, winning);
            } catch (IllegalArgumentException e) {
                OutputView.printError(e.getMessage());
            }
        }
    }
}