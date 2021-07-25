package algorithm.dp;

public class MaxNonAdjustmentElementsSum {

    public static void main(String[] args) {

    }

    static int maxSubsetSum(int[] arr) {
        int n = arr.length;
        int[] maxS = new int[n];
        long max = 0;
        for (int i = 0; i < n; i++) {
            int maxS2 = getPrev2(maxS, i);
            int maxS3 = getPrev3(maxS, i);
            int v = Math.max(arr[i], 0);
            maxS[i] = Math.max(maxS2, maxS3) + v;
            if (maxS[i] > max) {
                max = maxS[i];
            }
        }
        return (int) max;
    }

    static int getPrev2(int[] arr, int i) {
        try {
            return arr[i - 2];
        } catch (Exception e) {
            return 0;
        }
    }

    static int getPrev3(int[] arr, int i) {
        try {
            return arr[i - 3];
        } catch (Exception e) {
            return 0;
        }
    }

}
