package algorithm.common.maxsubarray;

import java.util.Arrays;

import static algorithm.common.maxsubarray.DivideAndConquerMaxSubarray.ArrInfo;

/**
 * Brute force: Complexity - O(n^2)
 *
 * @author BaladKV
 * @since 12.05.2020
 */
public class BruteForceMaxSubarray {

    public static void main(String[] args) {
        testBruteForce();
    }

    private static void testBruteForce() {
        // an example from Kormen's book
        int[] a = new int[]{13, -3, -25, 20, -3, -16, -23, 18, 20, -7, 12, -5, -22, 15, -4, 7};
        System.out.println("array:        " + Arrays.toString(a));
        ArrInfo info = bruteForceFindMaxSubarray(a);
        int[] maxSuba = Arrays.copyOfRange(a, info.l, info.r);
        System.out.println("max subarray: " + Arrays.toString(maxSuba) + " maxSum=" + info.sum);
        System.out.println("---------------------------------------------------------");

        // an example from wikipedia
        a = new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println("array:        " + Arrays.toString(a));
        info = bruteForceFindMaxSubarray(a);
        maxSuba = Arrays.copyOfRange(a, info.l, info.r);
        System.out.println("max subarray: " + Arrays.toString(maxSuba) + " maxSum=" + info.sum);
        System.out.println("=========================================================");
    }

    /**
     * Brute force solution with O(n^1) because of Combination of 2-elements boundaries across whole
     * array
     *
     * @param a array
     * @return info
     */
    public static ArrInfo bruteForceFindMaxSubarray(int[] a) {
        if (a == null || a.length == 0) {
            return null;
        }
        ArrInfo ret = new ArrInfo(0, 1, a[0]);
        for (int i = 0; i < a.length; i++) {
            int sum = 0;
            for (int j = i; j < a.length; j++) {
                sum += a[j];
                if (sum > ret.sum) {
                    ret.l = i;
                    ret.r = j + 1; // because of exclusive boundaries
                    ret.sum = sum;
                }
            }
        }
        return ret;
    }

}
