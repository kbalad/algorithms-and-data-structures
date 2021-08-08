package hackerrank.arrays;

import java.util.List;

/**
 * https://www.hackerrank.com/challenges/new-year-chaos
 *
 * We don't need to sort or anything else, everything is need:
 * 1. iterate over array
 * 2. count for the element amount of previous elements (with greater index) with greater value
 */
public class NewYearChaos {

    private NewYearChaos(){ }

    public static int routine(List<Integer> list) throws ImpossibleException {
        int res = 0;
        for (int i = list.size() - 1; i >= 0; i--) {
            int  v = list.get(i);
            checkBoundaryCondition(i, v);

            for (int j = Math.max(0, v - 2); j < i; j++) {
                if (list.get(j) > v) {
                    res++;
                }
            }
        }
        return res;
    }

    private static void checkBoundaryCondition(int i, int v) throws ImpossibleException {
        if (v - (i + 1) > 2) {
            throw new ImpossibleException();
        }
    }

    static class ImpossibleException extends Exception { }
}
