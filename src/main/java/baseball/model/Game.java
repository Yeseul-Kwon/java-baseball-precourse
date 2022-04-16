package baseball.model;

import baseball.ui.Input;
import baseball.ui.Output;

import java.util.ArrayList;

public class Game {

    public void gameStart(int length) {
        Opponent opponent = new Opponent();
        ArrayList<Integer> rightAnswer = opponent.getRightAnswer(length);
        Boolean isIncorrect = true;
        while (isIncorrect) {
            String input = Input.receiveNumberInput();
            Player player = new Player(input);
            ArrayList<Integer> inputAnswer = player.getInputAnswer(input);
            isIncorrect = gamePlay(rightAnswer, inputAnswer, length);
        }
    }

    private Boolean gamePlay(ArrayList<Integer> rightAnswer, ArrayList<Integer> inputAnswer, int length) {
        int ball = getBall(rightAnswer, inputAnswer, length);
        int strike = getStrike(rightAnswer, inputAnswer, length);

        String gameResult = getGameResult(ball, Output.RESULT_BALL_MESSAGE) + getGameResult(strike, Output.RESULT_STRIKE_MESSAGE);
        if (gameResult.equals("")) {
            gameResult = Output.RESULT_NOTHING_MESSAGE;
        }
        Output.printBaseballGameResult(gameResult);
        return isCorrect(strike, length);
    }

    private int getBall(ArrayList<Integer> rightAnswer, ArrayList<Integer> inputAnswer, int length) {
        int ball = 0;
        for (int i = 0; i < length; i++) {
            ball += (compareValue(rightAnswer, inputAnswer.get(i)) - compareLocationAndValue(rightAnswer.get(i), inputAnswer.get(i)));
        }
        return ball;
    }

    private int getStrike(ArrayList<Integer> rightAnswer, ArrayList<Integer> inputAnswer, int length) {
        int strike = 0;
        for (int i = 0; i < length; i++) {
            strike += compareLocationAndValue(rightAnswer.get(i), inputAnswer.get(i));
        }
        return strike;
    }

    public int compareValue(ArrayList<Integer> target, int value) {
        if (CommonFunction.overlapCheck(target, value)) {
            return 1;
        }
        return 0;
    }

    public int compareLocationAndValue(int rightAnswer, int inputAnswer) {
        if (rightAnswer == inputAnswer) {
            return 1;
        }
        return 0;
    }

    public String getGameResult(int ballOrStrike, String message) {
        if (ballOrStrike > 0) {
            return ballOrStrike + message;
        }
        return "";
    }

    public Boolean isCorrect(int strike, int length) {
        if (strike == length) {
            Output.printCorrectAnswer();
            return false;
        }
        return true;
    }
}
