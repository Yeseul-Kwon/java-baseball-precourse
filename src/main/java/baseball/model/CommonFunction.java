package baseball.model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class CommonFunction {
    public static Boolean overlapCheck(ArrayList<Integer> target) {
        Set<Integer> notDuplicatedInput = new HashSet<>(target);
        return !(notDuplicatedInput.size() == target.size());

    }

    public static Boolean compareNumber(int num1, int num2) {
        return (num1 == num2);
    }
}
