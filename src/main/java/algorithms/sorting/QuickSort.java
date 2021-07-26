package algorithms.sorting;

import java.util.Arrays;

/**
 * @author BaladKV
 * @since 09.06.2020
 */
public class QuickSort {

    public static void main(String[] args) {
        int[] a = new int[]{1, 10, 2, 9, 3, 8, 4, 7, 5, 6};
        sort(a, 0, a.length);
        System.out.println(Arrays.toString(a));
    }

    /**
     * make a sort on place in ascending order.
     * <p>complexity : O(n^2) in worst case and O(n*log(n)) in mean</p>
     *
     * @param a array
     * @param l left boundary (starting at 0)
     * @param r right boundary (exclusive)
     */
    public static void sort(int[] a, int l, int r) {
        if (l < r) {
            int newP = makePartition(a, l, r);
            sort(a, l, newP - 1);
            sort(a, newP, r);
        }
    }

    private static int makePartition(int[] a, int l, int r) {
        int x = a[r-1];
        int j = l;
        for (int i = l; i < r; i++) {
            if (a[i] < x) {
                // swap
                int w = a[j];
                a[j] = a[i];
                a[i] = w;
                j++; // move boundary
            }
        }
        // swap top right elem to make new pivot
        a[r-1] = a[j];
        a[j] = x;
        j++;
        return j;
    }
}
