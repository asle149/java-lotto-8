package lotto;
import domain.PurchaseAmount;
import ui.InputView;
import ui.NumberParser;

public class Application {
    public static void main(String[] args) {
        while (true) {
            try {
                final String raw = InputView.readPurchaseAmountRaw();
                final int value = NumberParser.parsePositiveInt(raw);
                return PurchaseAmount.of(value);
            } catch (IllegalArgumentException e) {

            }
    }
}
