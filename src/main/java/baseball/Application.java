package baseball;

import baseball.model.CommonFunction;
import baseball.model.Game;
import baseball.ui.Input;
import baseball.ui.Output;

public class Application {
    public static final int NUMBER_OF_DIGITS = 3;

    public static void main(String[] args) {
        Application application = new Application();
        Game game = new Game(NUMBER_OF_DIGITS);
        Boolean isReplay = true;
        while (isReplay) {
            game.gameStart();
            try {
                isReplay = application.isValidInput(Input.receiveReplayInput());
            } catch (IllegalArgumentException e) {
                System.exit(0);
            }
        }
    }

    private Boolean isValidInput(String input) throws IllegalArgumentException {
        if (!(input.equals("1") || input.equals("2"))) {
            Output.printExceptionMessage(Output.REPLAY_INPUT_FORMAT_EXCEPTION_MESSAGE);
            throw new IllegalArgumentException();
        }
        return (CommonFunction.compareNumber(Integer.parseInt(input), 1));
    }
}
