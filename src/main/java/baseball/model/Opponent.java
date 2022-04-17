package baseball.model;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;

public class Opponent {
    private ArrayList<Integer> answer;

    public Opponent() {
        answer = new ArrayList<>();
    }

    public ArrayList<Integer> getRightAnswer(int numberOfDigit) {
        while (answer.size() < numberOfDigit) {
            addNumber();
        }
        return answer;
    }

    private void addNumber() {
        int number = Randoms.pickNumberInRange(1, 9);
        answer.add(number);
        if ((CommonFunction.overlapCheck(answer))) {
            answer.remove(answer.size() - 1);
        }
    }
}
