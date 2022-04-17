package baseball.model;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.assertj.core.api.Assertions.assertThat;

public class OpponentTest {
    private static Opponent opponent;
    private static ArrayList<Integer> rightAnswer;

    @BeforeAll
    static void initAll() {
        opponent = new Opponent();
    }

    @Test
    void getRightAnswer_size() {
        rightAnswer = opponent.getRightAnswer(3);

        assertThat(rightAnswer.size()).isEqualTo(3);
    }

    @Test
    void getRightAnswer_isValidValue() {
        rightAnswer = opponent.getRightAnswer(3);

        for (int num : rightAnswer) {
            assertThat(num).isBetween(1, 9).isNotZero();
        }
    }
}
