package baseball.model;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.assertj.core.api.Assertions.assertThat;

public class CommonFunctionTest {

    @BeforeAll
    static void initAll() {
    }

    @Test
    void overlapCheck_true() {
        ArrayList<Integer> testList = new ArrayList<>();
        testList.add(1);
        testList.add(2);
        testList.add(1);
        assertThat(CommonFunction.overlapCheck(testList)).isEqualTo(true);
    }

    @Test
    void overlapCheck_false() {
        ArrayList<Integer> testList = new ArrayList<>();
        testList.add(1);
        testList.add(2);
        testList.add(3);
        assertThat(CommonFunction.overlapCheck(testList)).isEqualTo(false);
    }

    @Test
    void compareNumber_true() {
        assertThat(CommonFunction.compareNumber(1, 1)).isEqualTo(true);
    }

    @Test
    void compareNumber_false() {
        assertThat(CommonFunction.compareNumber(1, 2)).isEqualTo(false);
    }
}
