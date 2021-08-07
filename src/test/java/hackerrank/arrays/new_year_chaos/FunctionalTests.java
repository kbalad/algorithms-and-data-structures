package hackerrank.arrays.new_year_chaos;

import hackerrank.Utils;
import hackerrank.arrays.new_year_chaos.NewYearChaos.ImpossibleException;
import java.util.Arrays;
import java.util.List;
import lombok.SneakyThrows;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class FunctionalTests {

    @Test
    @SneakyThrows
    public void checkOkWithoutSwaps() {
        int expected = 0;
        int actual = NewYearChaos.routine(Arrays.asList(1, 2, 3));
        assertEquals(actual, expected);
    }

    @Test
    @SneakyThrows
    public void checkOkWithSwaps() {
        List<Integer> input = Utils.createList("2 1 5 3 4");

        int expected = 3;
        int actual = NewYearChaos.routine(input);
        assertEquals(actual, expected);
    }

    @Test(expectedExceptions = ImpossibleException.class)
    @SneakyThrows
    public void checkImpossible() {
        NewYearChaos.routine(Utils.createList("2 5 1 3 4"));
    }

}
