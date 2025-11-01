package lotto;

import domain.BonusNumber;
import domain.LottoMachine;
import domain.PurchaseAmount;
import domain.Rank;
import domain.ResultCalculator;
import domain.WinningNumbers;
import ui.CsvParser;
import ui.InputView;
import ui.NumberParser;
import ui.OutputView;

import java.util.List;
import java.util.Map;

public class Application {

    public static void main(String[] args) {
        int count = readPurchaseCountWithRetry();
        List<Lotto> tickets = LottoMachine.publish(count);
        OutputView.printPurchasedCount(count);
        OutputView.printTickets(tickets);

        WinningNumbers winning = readWinningNumbersWithRetry();
        BonusNumber bonus = readBonusNumberWithRetry(winning);

        Map<Rank, Integer> result = ResultCalculator.calculate(tickets, winning, bonus);
        OutputView.printResult(result);
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