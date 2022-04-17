package baseball.model;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;

import static org.assertj.core.api.Assertions.assertThat;

public class GameTest {
    private static Game game;
    private static ArrayList<Integer> rightAnswer;

    @BeforeAll
    static void initAll() {
        game = new Game();

        rightAnswer = new ArrayList<>();
        rightAnswer.add(1);
        rightAnswer.add(2);
        rightAnswer.add(3);
    }

    @Test
    void gamePlay_isNothing() {
        ArrayList<Integer> inputAnswer = new ArrayList<>();

        inputAnswer.add(4);
        inputAnswer.add(5);
        inputAnswer.add(6);

        try {
            Method method = game.getClass().getDeclaredMethod("gamePlay", ArrayList.class, ArrayList.class, int.class);
            method.setAccessible(true);
            Boolean isCorrect = (Boolean) method.invoke(game, rightAnswer, inputAnswer, 3);
            assertThat(isCorrect).isEqualTo(false);
        } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }
    }

    @Test
    void gamePlay_isIncorrect() {
        ArrayList<Integer> inputAnswer = new ArrayList<>();

        inputAnswer.add(1);
        inputAnswer.add(3);
        inputAnswer.add(4);

        try {
            Method method = game.getClass().getDeclaredMethod("gamePlay", ArrayList.class, ArrayList.class, int.class);
            method.setAccessible(true);
            Boolean isCorrect = (Boolean) method.invoke(game, rightAnswer, inputAnswer, 3);
            assertThat(isCorrect).isEqualTo(false);
        } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }
    }

    @Test
    void gamePlay_isCorrect() {
        ArrayList<Integer> inputAnswer = new ArrayList<>();

        inputAnswer.add(1);
        inputAnswer.add(2);
        inputAnswer.add(3);

        try {
            Method method = game.getClass().getDeclaredMethod("gamePlay", ArrayList.class, ArrayList.class, int.class);
            method.setAccessible(true);
            Boolean isCorrect = (Boolean) method.invoke(game, rightAnswer, inputAnswer, 3);
            assertThat(isCorrect).isEqualTo(true);
        } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }
    }

    @Test
    void getBall() {
        ArrayList<Integer> inputAnswer = new ArrayList<>();

        inputAnswer.add(3);
        inputAnswer.add(2);
        inputAnswer.add(1);

        try {
            Method method = game.getClass().getDeclaredMethod("getBall", ArrayList.class, ArrayList.class, int.class);
            method.setAccessible(true);
            int ballCount = (int) method.invoke(game, rightAnswer, inputAnswer, 3);
            assertThat(ballCount).isEqualTo(2);
        } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }
    }

    @Test
    void getStrike() {
        ArrayList<Integer> inputAnswer = new ArrayList<>();

        inputAnswer.add(3);
        inputAnswer.add(2);
        inputAnswer.add(1);

        try {
            Method method = game.getClass().getDeclaredMethod("getStrike", ArrayList.class, ArrayList.class, int.class);
            method.setAccessible(true);
            int ballCount = (int) method.invoke(game, rightAnswer, inputAnswer, 3);
            assertThat(ballCount).isEqualTo(1);
        } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }
    }
}
