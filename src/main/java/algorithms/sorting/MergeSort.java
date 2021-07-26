package algorithms.sorting;

import java.util.Arrays;
import java.util.Random;

/**
 * @author BaladKV
 * @since 10.05.2020
 */
public class MergeSort {

    /**
     * Invasive ascending sort with complexity of O(n*ln(n))
     *
     * @param a modifiable array
     * @param l left index (inclusive, starting at 0)
     * @param r right index (exclusive)
     */
    public static void sort(int[] a, int l, int r) {
        if (r - l > 1) { // if more than one element in a
            int m = (l + r) / 2;
            sort(a, l, m);
            sort(a, m, r);
            merge(a, l, m, r);
        }
    }

    private static void merge(int[] a, int l, int m, int r) {
        int[] la = Arrays.copyOfRange(a, l, m);
        int[] ra = Arrays.copyOfRange(a, m, r);
        int i = 0, j = 0;
        int ptr = l;
        while (i < la.length && j < ra.length) {
            if (la[i] < ra[j]) {
                a[ptr++] = la[i++];
            } else {
                a[ptr++] = ra[j++];
            }
        }
        while (i != la.length) {
            a[ptr++] = la[i++];
        }
        while (j != ra.length) {
            a[ptr++] = ra[j++];
        }
    }

    public static void main(String[] args) {
        Random rnd = new Random();
        int[] a = new int[10];
        for (int i = 0; i < a.length; i++) {
            a[i] = rnd.nextInt(a.length * a.length);
        }
        System.out.println("was: " + Arrays.toString(a));

        int[] c = a.clone();
        Arrays.sort(c);

        sort(a, 0, a.length);
        System.out.println("aft: " + Arrays.toString(a));

        assert Arrays.equals(a, c);
    }
}
