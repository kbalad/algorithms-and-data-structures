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

    public static int[] sort(int[] a) {
        int n = a.length;
        int[] cnt = new int[n];
        int[] res = new int[n];

        for (int i = 0; i < n; i++) {
            cnt[a[i]]++;
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
}
