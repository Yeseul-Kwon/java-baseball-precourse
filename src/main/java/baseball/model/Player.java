package baseball.model;

import baseball.Application;
import baseball.ui.Output;

import java.util.ArrayList;

public class Player {
    private String input;
    private ArrayList<Integer> typeConvertedAnswer;

    public Player(){}

    public Player(String input) {
        try {
            this.input = input;
            this.typeConvertedAnswer = new ArrayList<>();
            isValidInputFormat();
            isValidInputSize();
            isValidInputDuplicate();
        } catch (IllegalArgumentException e) {
            System.exit(0);
        }
    }

    public ArrayList<Integer> getInputAnswer() {
        for (int i = 0; i < input.length(); i++) {
            typeConvertedAnswer.add((input.charAt(i) - 48));
        }
        return typeConvertedAnswer;
    }

    private void isValidInputFormat() throws IllegalArgumentException {
        if (!input.matches("^[1-9]*?")) {
            Output.printExceptionMessage(Output.INPUT_NUMBER_FORMAT_EXCEPTION_MESSAGE);
            throw new IllegalArgumentException();
        }
    }

    private void isValidInputSize() throws IllegalArgumentException {
        if (input.length() != Application.NUMBER_OF_DIGITS) {
            Output.printExceptionMessage(Application.NUMBER_OF_DIGITS + Output.BASEBALL_SIZE_EXCEPTION_MESSAGE);
            throw new IllegalArgumentException();
        }
    }

    private void isValidInputDuplicate() throws IllegalArgumentException {
        if (CommonFunction.overlapCheck(getInputAnswer())) {
            Output.printExceptionMessage(Output.BASEBALL_DUPLICATE_EXCEPTION_MESSAGE);
            throw new IllegalArgumentException();
        }
    }
}
