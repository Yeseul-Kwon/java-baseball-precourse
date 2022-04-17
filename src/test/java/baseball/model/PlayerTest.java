package baseball.model;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class PlayerTest {
    private static Player player;

    @BeforeAll
    static void initAll() {
    }

    @Test
    void getRightAnswer_size() {
        player = new Player();
        ArrayList<Integer> inputAnswer = player.getInputAnswer();

        assertThat(inputAnswer.size()).isEqualTo(3);
    }

    @Test
    void player_exception_isValidInputFormat() {
        assertThrows(IllegalArgumentException.class, () -> {
            player = new Player("ABC");
        });
    }

    @Test
    void player_exception_isValidInputSize() {
        assertThrows(IllegalArgumentException.class, () -> {
            player = new Player("12345");
        });
    }

    @Test
    void player_exception_isValidInputDuplicate() {
        assertThrows(IllegalArgumentException.class, () -> {
            player = new Player("121");
        });
    }
}
