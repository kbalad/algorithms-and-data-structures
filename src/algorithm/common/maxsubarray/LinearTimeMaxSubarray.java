package algorithm.common.maxsubarray;

/**
 * @author BaladKV
 * @since 12.05.2020
 */
public class LinearTimeMaxSubarray {

    public static int kadane(int[] a) {
        int maxSoFar = 0;
        int maxEndingHere = 0;
        for (int value : a) {
            maxEndingHere = maxEndingHere + value;
            maxEndingHere = Integer.max(maxEndingHere, 0);
            maxSoFar = Integer.max(maxSoFar, maxEndingHere);
        }
        return maxSoFar;
    }
}
