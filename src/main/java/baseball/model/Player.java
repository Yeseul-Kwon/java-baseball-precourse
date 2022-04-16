package baseball.model;

import baseball.Application;
import baseball.ui.Output;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class Player {
    private ArrayList<Integer> typeConvertedAnswer;

    public Player(String input) {
        try {
            isValidInputFormat(input);
            isValidInputSize(input);
            isValidInputDuplicate(input);
        } catch (IllegalArgumentException e) {
            System.exit(0);
        }
    }

    public ArrayList<Integer> getInputAnswer(String input) {
        typeConvertedAnswer = new ArrayList<Integer>();
        for (int i = 0; i < input.length(); i++) {
            typeConvertedAnswer.add((input.charAt(i) - 48));
        }
        return typeConvertedAnswer;
    }

    private void isValidInputFormat(String input) throws IllegalArgumentException {
        if (!input.matches("^[1-9]*?")) {
            Output.printExceptionMessage(Output.INPUT_NUMBER_FORMAT_EXCEPTION_MESSAGE);
            throw new IllegalArgumentException();
        }
    }

    private void isValidInputSize(String input) throws IllegalArgumentException {
        if (input.length() != Application.MAX_LENGTH) {
            Output.printExceptionMessage(Application.MAX_LENGTH + Output.BASEBALL_SIZE_EXCEPTION_MESSAGE);
            throw new IllegalArgumentException();
        }
    }

    private void isValidInputDuplicate(String input) throws IllegalArgumentException {
        Set<Integer> deduplicatedInput = new HashSet<>(getInputAnswer(input));
        if (deduplicatedInput.size() != input.length()) {
            Output.printExceptionMessage(Output.BASEBALL_DUPLICATE_EXCEPTION_MESSAGE);
            throw new IllegalArgumentException();
        }
    }
}
