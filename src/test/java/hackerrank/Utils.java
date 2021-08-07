package hackerrank;

import com.google.common.primitives.Ints;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Utils {

    public static int[] createArray(String s) {
        return Arrays.stream(s.split(" "))
            .mapToInt(Integer::parseInt)
            .toArray();
    }

    public static List<Integer> createList(String s) {
        int[] a = createArray(s);
        return Ints.asList(a);
    }

}
