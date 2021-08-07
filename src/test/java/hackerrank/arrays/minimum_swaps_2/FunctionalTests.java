package hackerrank.arrays.minimum_swaps_2;

import hackerrank.Utils;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class FunctionalTests {

    private int[] input;
    private int expected;

    private void setupData(String input, int expected) {
        this.input = Utils.createArray(input);
        this.expected = expected;
    }

    private void assertRoutine() {
        assertEquals(new MinimumSwaps(input).routine(), expected);
    }

    @BeforeTest
    public void initData() {
        this.input = null;
        this.expected = -1;
    }

    @Test
    public void checkOk() {
        setupData("4 3 1 2", 3);
        assertRoutine();
    }

    @Test
    public void checkOk2() {
        setupData("2 3 4 1 5", 3);
        assertRoutine();
    }

    @Test
    public void checkOk3() {
        setupData("1 3 5 2 4 6 7", 3);
        assertRoutine();
    }
}
