package baseball;

import baseball.model.Game;
import baseball.ui.Input;
import baseball.ui.Output;

public class Application {
    public static final int MAX_LENGTH = 3;

    public static void main(String[] args) {
        Application application = new Application();
        Boolean isReplay = true;
        Game game = new Game();
        while (isReplay) {
            game.gameStart(MAX_LENGTH);
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
        if (input.equals("1")) {
            return true;
        }
        return false;
    }
}
