package algorithm.common.maxsubarray;

import algorithm.common.maxsubarray.DivideAndConquerMaxSubarray.ArrInfo;
import java.util.Arrays;

/**
 * @author BaladKV
 * @since 12.05.2020
 */
public class LinearTimeMaxSubarray {

    public static void main(String[] args) {
        testPartialSumsAlgorithm();
        testKadaneAlgorithm();
    }

    private static void testPartialSumsAlgorithm() {
        // an example from Kormen's book
        int[] a = new int[]{13, -3, -25, 20, -3, -16, -23, 18, 20, -7, 12, -5, -22, 15, -4, 7};
        System.out.println("array:        " + Arrays.toString(a));
        ArrInfo info = findMaxSubarrayByPartialSum(a);
        int[] maxSuba = Arrays.copyOfRange(a, info.l, info.r);
        System.out.println("max subarray: " + Arrays.toString(maxSuba) + " maxSum=" + info.sum);
        System.out.println("---------------------------------------------------------");

        // an example from wikipedia
        a = new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println("array:        " + Arrays.toString(a));
        info = findMaxSubarrayByPartialSum(a);
        maxSuba = Arrays.copyOfRange(a, info.l, info.r);
        System.out.println("max subarray: " + Arrays.toString(maxSuba) + " maxSum=" + info.sum);
        System.out.println("=========================================================");
    }

    private static void testKadaneAlgorithm() {
        // an example from Kormen's book
        int[] a = new int[]{13, -3, -25, 20, -3, -16, -23, 18, 20, -7, 12, -5, -22, 15, -4, 7};
        System.out.println("array:        " + Arrays.toString(a));
        ArrInfo info = kadane(a);
        int[] maxSuba = Arrays.copyOfRange(a, info.l, info.r);
        System.out.println("max subarray: " + Arrays.toString(maxSuba) + " maxSum=" + info.sum);
        System.out.println("---------------------------------------------------------");

        // an example from wikipedia
        a = new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println("array:        " + Arrays.toString(a));
        info = kadane(a);
        maxSuba = Arrays.copyOfRange(a, info.l, info.r);
        System.out.println("max subarray: " + Arrays.toString(maxSuba) + " maxSum=" + info.sum);
        System.out.println("=========================================================");
    }

    /**
     * Solution with O(n) named by inventor : Jay Kadane
     *
     * @param a array
     * @return info
     */
    public static ArrInfo kadane(int[] a) {
        int ans = a[0],
            ansL = 0,
            ansR = 0,
            sum = 0,
            minusPos = -1;
        for (int r = 0; r < a.length; r++) {
            sum += a[r];
            if (sum > ans) {
                ans = sum;
                ansL = minusPos + 1;
                ansR = r + 1;
            }
            if (sum < 0) {
                sum = 0;
                minusPos = r;
            }
        }
        return new ArrInfo(ansL, ansR, ans);
    }

    /**
     * Solution of O(n) using partial sum from the start of arrays.
     *
     * <p>Main principle: sum(l, r) = sum(0, r) - sum(0, l-1)</p>
     *
     * @param a array
     * @return info
     */
    public static ArrInfo findMaxSubarrayByPartialSum(int[] a) {
        int sum = 0, // current sum of arr[0..i]
            ans = a[0], // answer
            ansL = 0, // left boundary for max subarray
            ansR = 0, // right boundary for max subarrya (excl)
            minSum = 0, // minSum of arr[0..minPos]
            minPos = 0;
        for (int r = 0; r < a.length; r++) {
            sum += a[r];
            int cur = sum - minSum;
            if (cur > ans) {
                ans = cur;
                ansL = minPos; // exclusive
                ansR = r + 1; // exclusive
            }
            if (sum < minSum) {
                minSum = sum;
                minPos = r + 1;
            }
        }
        return new ArrInfo(ansL, ansR, ans);
    }

}
