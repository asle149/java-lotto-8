package lotto;

import domain.LottoMachine;
import domain.PurchaseAmount;
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
}