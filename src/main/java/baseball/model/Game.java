package baseball.model;

import baseball.ui.Input;
import baseball.ui.Output;

import java.util.ArrayList;

public class Game {
    private int NUMBER_OF_DIGITS;

    public Game() {
    }

    public Game(int numberOfDigits) {
        this.NUMBER_OF_DIGITS = numberOfDigits;
    }

    public void gameStart() {
        Opponent opponent = new Opponent();
        ArrayList<Integer> rightAnswer = opponent.getRightAnswer(NUMBER_OF_DIGITS);

        Boolean isCorrect = false;
        while (!isCorrect) {
            Player player = new Player(Input.receiveNumberInput());
            ArrayList<Integer> inputAnswer = player.getInputAnswer();
            isCorrect = gamePlay(rightAnswer, inputAnswer);
        }
    }

    private Boolean gamePlay(ArrayList<Integer> rightAnswer, ArrayList<Integer> inputAnswer) {
        int ball = getBall(rightAnswer, inputAnswer);
        int strike = getStrike(rightAnswer, inputAnswer);

        String gameResult = getGameResult(ball, Output.RESULT_BALL_MESSAGE) + getGameResult(strike, Output.RESULT_STRIKE_MESSAGE);
        if (gameResult.equals("")) {
            gameResult = Output.RESULT_NOTHING_MESSAGE;
        }
        Output.printBaseballGameResult(gameResult);
        return isCorrect(strike);
    }

    private int getBall(ArrayList<Integer> rightAnswer, ArrayList<Integer> inputAnswer) {
        int ball = 0;
        for (int i = 0; i < NUMBER_OF_DIGITS; i++) {
            ball += (compareValue(rightAnswer, inputAnswer.get(i)) - compareSameLocationValue(rightAnswer.get(i), inputAnswer.get(i)));
        }
        return ball;
    }

    private int getStrike(ArrayList<Integer> rightAnswer, ArrayList<Integer> inputAnswer) {
        int strike = 0;
        for (int i = 0; i < NUMBER_OF_DIGITS; i++) {
            strike += compareSameLocationValue(rightAnswer.get(i), inputAnswer.get(i));
        }
        return strike;
    }

    private int compareValue(ArrayList<Integer> target, int value) {
        ArrayList<Integer> targetList = new ArrayList<>(target);
        targetList.add(value);
        if (CommonFunction.overlapCheck(targetList)) {
            return 1;
        }
        return 0;
    }

    private int compareSameLocationValue(int rightAnswer, int inputAnswer) {
        if (CommonFunction.compareNumber(rightAnswer, inputAnswer)) {
            return 1;
        }
        return 0;
    }

    private String getGameResult(int ballOrStrike, String message) {
        if (ballOrStrike > 0) {
            return ballOrStrike + message;
        }
        return "";
    }

    private Boolean isCorrect(int strike) {
        if (CommonFunction.compareNumber(strike, NUMBER_OF_DIGITS)) {
            Output.printCorrectAnswer();
            return true;
        }
        return false;
    }
}
