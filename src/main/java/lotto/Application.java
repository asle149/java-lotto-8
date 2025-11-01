package lotto;

import domain.LottoMachine;
import domain.PurchaseAmount;
import domain.WinningNumbers;
import ui.CsvParser;
import ui.InputView;
import ui.NumberParser;
import ui.OutputView;

import java.util.List;

public class Application {

    public static void main(String[] args) {
        int count = readPurchaseCountWithRetry();
        List<Lotto> tickets = LottoMachine.publish(count);
        OutputView.printPurchasedCount(count);
        OutputView.printTickets(tickets);

        WinningNumbers winning = readWinningNumbersWithRetry();

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
}