package hackerrank.greedy;

import static org.testng.Assert.*;

import hackerrank.Utils;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class MinimumAbsolutDifferenceInAnArrayTest {

    @DataProvider(name = "data")
    public static Object[][] inputAndExpected() {
        return new Object[][] {
            {"3 -7 0", 3},
            {"-59 -36 -13 1 -53 -92 -2 -96 -54 75", 1},
            {"1 -3 71 68 17", 3}
        };
    }

    @Test(dataProvider = "data")
    public void checkOk(String inputString, int expected) {
        int[] input = Utils.createArray(inputString);
        MinimumAbsolutDifferenceInAnArray solver = new MinimumAbsolutDifferenceInAnArray(input);

        int actual = solver.routine();
        assertEquals(actual, expected);
    }
}