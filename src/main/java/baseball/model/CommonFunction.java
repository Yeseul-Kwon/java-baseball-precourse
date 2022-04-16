package baseball.model;

import java.util.ArrayList;

public class CommonFunction {
    public static Boolean overlapCheck(ArrayList<Integer> target, int number) {
        Boolean result = false;
        for (int i = 0; i < target.size(); i++) {
            result = result || comepareNumber(target.get(i), number);
        }
        return result;
    }

    private static Boolean comepareNumber(int num1, int num2) {
        if (num1 == num2) {
            return true;
        }
        return false;
    }
}
