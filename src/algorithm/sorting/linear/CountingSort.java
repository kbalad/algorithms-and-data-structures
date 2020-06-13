package algorithm.sorting.linear;

/**
 * Linear-time sorting supported by backing counting storage.
 *
 * @author BaladKV
 * @since 13.06.2020
 */
public class CountingSort {

    public static void main(String[] args) {
        int[] a = new int[]{1, 9, 2, 5, 8, 3, 7, 4, 6, 5};
        int[] b = sort(a);
        System.out.println(java.util.Arrays.toString(b));
    }

    /**
     * Simple sort of numbers in array;
     * <p>The elements value shouldn't exceed {@code value a.length - 1}
     * (e.g. array {@code {1,2,3}} is not correct, because {@code 3 > 2}</p>
     *
     * @param a array
     * @return new sorted array
     */
    public static int[] sort(int[] a) {
        int n = a.length;
        int[] cnt = new int[n];
        int[] res = new int[n];

        for (int num : a) {
            cnt[num]++;
        }
        for (int i = 1; i < n; i++) {
            cnt[i] += cnt[i - 1];
        }
        for (int i = n - 1; i >= 0; i--) {
            int pos = cnt[a[i]] - 1;
            res[pos] = a[i];
            cnt[a[i]]--;
        }
        return res;
    }

    /**
     * Sort an array of numbers by {@code exp}-digit (starting from the least significant digit
     * ({@code 0})) in ascending order.
     * <p>Actively used as subroutine in radix-sort.</p>
     *
     * @param a   original array
     * @param exp by which number the counting is processed (starting from {@code 0})
     * @return new sorted array
     */
    public static int[] sort(int[] a, int exp) {
        final int base = 10;
        int n = a.length;
        int[] cnt = new int[base]; // 10 is the base of digits-alphabet
        int[] res = new int[n];

        for (int num : a) {
            int digit = (num / exp) % base;
            cnt[digit]++;
        }
        for (int i = 1; i < n; i++) {
            cnt[i] += cnt[i - 1];
        }
        for (int i = n - 1; i >= 0; i--) {
            int digit = (a[i] / exp) % base;
            int pos = cnt[digit] - 1;
            res[pos] = a[i];
            cnt[digit]--;
        }
        return res;
    }
}
