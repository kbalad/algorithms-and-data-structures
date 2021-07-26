package algorithms.sorting.linear;

import java.util.Arrays;

/**
 * @author BaladKV
 * @since 13.06.2020
 */
public class RadixSort {

    public static void main(String[] args) {
        int[] a = new int[]{1, 9, 2, 5, 8, 3, 7, 4, 6, 5};
        int[] b = sort(a);
        System.out.println(Arrays.toString(b));
    }

    /**
     * Sort numbers in ascending order.
     * <p>As a sub-routine uses CountingSort.</p>
     *
     * @param a array with nums
     * @return new (sorted) array
     */
    public static int[] sort(int[] a) {
        int max = getMaxValue(a);
        int[] newA = Arrays.copyOf(a, a.length);
        for (int exp = 1; max / exp > 0; exp *= 10) {
            newA = CountingSort.sort(newA, exp);
        }
        return newA;
    }

    private static int getMaxValue(int[] a) {
        if (a == null || a.length == 0) {
            throw new IllegalArgumentException("Array should not be empty");
        }
        int max = a[0];
        for (int i = 1; i < a.length; i++) {
            if (a[i] > max) {
                max = a[i];
            }
        }
        return max;
    }
}
