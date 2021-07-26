package algorithms.common.maxsubarray;

import java.util.Arrays;

/**
 * D&C Solution : complexity O(n*lg(n))
 *
 * @author BaladKV
 * @since 12.05.2020
 */
public class DivideAndConquerMaxSubarray {

    public static void main(String[] args) {
        testDivideAndConquer();
    }

    private static void testDivideAndConquer() {
        // an example from Kormen's book
        int[] a = new int[]{13, -3, -25, 20, -3, -16, -23, 18, 20, -7, 12, -5, -22, 15, -4, 7};
        System.out.println("array:        " + Arrays.toString(a));
        ArrInfo info = divideAndConquerFindMaxSubarray(a, new ArrInfo(0, a.length, 0));
        int[] maxSuba = Arrays.copyOfRange(a, info.l, info.r);
        System.out.println("max subarray: " + Arrays.toString(maxSuba) + " maxSum=" + info.sum);
        System.out.println("---------------------------------------------------------");

        // an example from wikipedia
        a = new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println("array:        " + Arrays.toString(a));
        info = divideAndConquerFindMaxSubarray(a, new ArrInfo(0, a.length, 0));
        maxSuba = Arrays.copyOfRange(a, info.l, info.r);
        System.out.println("max subarray: " + Arrays.toString(maxSuba) + " maxSum=" + info.sum);
        System.out.println("=========================================================");
    }

    /**
     * Divide and conquer method with O(n*lg(n))
     *
     * @param a array of nums
     * @param e info about about boundaries and current max value
     * @return Info
     */
    public static ArrInfo divideAndConquerFindMaxSubarray(int[] a, ArrInfo e) {
        if (e.r - 1 == e.l) {
            return new ArrInfo(e.l, e.r, a[e.l]);
        }
        int med = (e.l + e.r) / 2;
        ArrInfo leftInfo = divideAndConquerFindMaxSubarray(a, new ArrInfo(e.l, med, 0));
        ArrInfo rightInfo = divideAndConquerFindMaxSubarray(a, new ArrInfo(med, e.r, 0));
        ArrInfo intersectionInfo = intersectionFindMaxSubarray(a, e, med);
        return ArrInfo.getMax(leftInfo, rightInfo, intersectionInfo);
    }

    private static ArrInfo intersectionFindMaxSubarray(int[] a, ArrInfo e, int med) {
        int maxIndLeft = med - 1;
        int maxValLeft = a[med - 1];
        int sum = 0;
        for (int i = med - 1; i >= e.l; i--) {
            sum += a[i];
            if (sum > maxValLeft) {
                maxIndLeft = i;
                maxValLeft = sum;
            }
        }

        sum = 0;
        int maxIndRight = med;
        int maxValRight = a[med];
        for (int i = med; i < e.r; i++) {
            sum += a[i];
            if (sum > maxValRight) {
                maxValRight = sum;
                maxIndRight = i;
            }
        }

        return new ArrInfo(maxIndLeft, maxIndRight + 1, maxValLeft + maxValRight);
    }

    // best range with max subarr
    public static class ArrInfo {

        int l; // inclusive left boundary
        int r; // exclusive right boundary
        int sum; // sum of the arr

        public ArrInfo(int l, int r, int sum) {
            this.l = l;
            this.r = r;
            this.sum = sum;
        }

        public static ArrInfo getMax(ArrInfo... ia) {
            int max = Integer.MIN_VALUE;
            int maxInd = -1;
            for (int i = 0; i < ia.length; i++) {
                if (ia[i].sum > max) {
                    maxInd = i;
                    max = ia[i].sum;
                }
            }
            if (maxInd >= 0) {
                return ia[maxInd];
            } else {
                return null;
            }
        }
    }
}
