package algorithm.sorting;

import java.util.Arrays;
import java.util.Random;

/**
 * @author BaladKV
 * @since 09.05.2020
 */
public class InsertionSort {

    /**
     * Non-Invasive ascending sort with O(n^2)
     *
     * @param b given array (won't be modified)
     * @return new array
     */
    public static int[] sort(int[] b) {
        int[] a = b.clone();
        final int n = a.length;
        for (int i = 1; i < n; i++) {
            int el = a[i];
            int j = i - 1;
            while (j >= 0 && a[j] > el) { // ascending
                a[j + 1] = a[j];
                j--;
            }
            a[j + 1] = el;
        }
        return a;
    }

    public static void main(String[] args) {
        Random rnd = new Random();
        int[] a = new int[10];
        for (int i = 0; i < a.length; i++) {
            a[i] = rnd.nextInt(a.length * a.length);
        }
        System.out.println("was: " + Arrays.toString(a));

        int[] b = sort(a);
        System.out.println("aft: " + Arrays.toString(b));

        int[] c = a.clone();
        Arrays.sort(c);

        assert Arrays.equals(b, c);
    }
}
