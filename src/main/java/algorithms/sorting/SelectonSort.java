package algorithms.sorting;

import java.util.Arrays;
import java.util.Random;

/**
 * @author BaladKV
 * @since 10.05.2020
 */
public class SelectonSort {

    /**
     * Non-Invasive ascending sort with O(n^2)
     *
     * @param b given array (won't be modified)
     * @return new array
     */
    public static int[] sort(int[] b) {
        int[] a = b.clone();
        int n = a.length;

        for (int i = 0; i < n - 1; i++) {
            int min = a[i];
            int minInd = i;
            for (int j = i + 1; j < n; j++) {
                if (a[j] < min) {
                    min = a[j];
                    minInd = j;
                }
            }
            // swap
            a[minInd] = a[i];
            a[i] = min;
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
