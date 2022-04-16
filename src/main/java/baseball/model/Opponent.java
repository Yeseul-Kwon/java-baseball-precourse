package baseball.model;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;

public class Opponent {
    private ArrayList<Integer> answer;

    public Opponent() {
        answer = new ArrayList<Integer>();
    }

    public ArrayList<Integer> getRightAnswer(int length) {
        while (answer.size() < length) {
            addNumber(answer);
        }
        return answer;
    }

    private void addNumber(ArrayList<Integer> answer) {
        int number = Randoms.pickNumberInRange(1, 9);
        if (pickSuccess(answer, number)) {
            answer.add(number);
        }
    }

    public static Boolean pickSuccess(ArrayList<Integer> pickNumberList, int pickNum) {
        if (CommonFunction.overlapCheck(pickNumberList, pickNum)) {
            return false;
        }
        return true;
    }

}
