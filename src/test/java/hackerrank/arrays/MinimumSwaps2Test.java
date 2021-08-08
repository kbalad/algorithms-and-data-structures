package hackerrank.arrays;

import hackerrank.Utils;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class MinimumSwaps2Test {

    @DataProvider(name = "data")
    public static Object[][] inputAndExpectedData() {
        return new Object[][] {
            {"4 3 1 2", 3},
            {"2 3 4 1 5", 3},
            {"1 3 5 2 4 6 7", 3}
        };
    }

    @Test(dataProvider = "data")
    public void checkOk(String inputString, int expected) {
        int[] input = Utils.createArray(inputString);
        int actual = new MinimumSwaps2(input).routine();
        Assert.assertEquals(actual, expected);
    }
}
