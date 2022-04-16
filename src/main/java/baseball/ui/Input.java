package baseball.ui;

import camp.nextstep.edu.missionutils.Console;

public class Input {
    public static String receiveNumberInput() {
        Output.printRequestNumberInput();
        return Console.readLine();
    }

    public static String receiveReplayInput() {
        Output.printRequestReplayInput();
        return Console.readLine();
    }
}
