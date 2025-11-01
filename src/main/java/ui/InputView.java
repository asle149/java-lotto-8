package ui;

import camp.nextstep.edu.missionutils.Console;

public final class InputView {
    private InputView() {}

    public static String readPurchaseAmountRaw() {
        System.out.println("구입금액을 입력해 주세요.");
        return Console.readLine();
    }

    public static String readWinningNumbersRaw() {
        System.out.println("당첨 번호를 입력해 주세요.");
        return Console.readLine();
    }

    public static String readBonusNumberRaw() {
        System.out.println("보너스 번호를 입력해 주세요.");
        return Console.readLine();
    }
}