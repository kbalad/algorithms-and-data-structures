package algorithm.sorting;

import java.util.Arrays;
import java.util.Random;

/**
 * @author BaladKV
 * @since 10.05.2020
 */
public class BubbleSort {

    /**
     * Invasive ascending sort with complexity of O(n^2)
     *
     * @param a modifiable array
     */
    public static void sort(int[] a) {
        final int n = a.length;
        for (int i = 1; i < n; i++) {
            for (int j = i; j > 0; j--) {
                if (a[j-1] > a[j]) {
                    //swap
                    a[j-1] = a[j] ^ a[j-1];
                    a[j] = a[j] ^ a[j-1];
                    a[j-1] = a[j] ^ a[j-1];
                }
            }
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

        sort(a);
        System.out.println("aft: " + Arrays.toString(a));

        assert Arrays.equals(a, c);
    }
}
