package algorithm.sorting;

import datastructures.Heap;
import java.util.Arrays;

/**
 * Sorting in ascending order of an integer array using Heap in O(n*ln(n)) time.
 * <p>The method changes original array.</p>
 *
 * @author BaladKV
 * @since 31.05.2020
 */
public class HeapSort {

    public static void main(String[] args) {
        int[] a = new int[]{1, 2, 4, 5};
        HeapSort.sort(a);
        System.out.println(Arrays.toString(a));
    }

    public static void sort(int[] a) {
        Heap.heapsort(a);
    }
}
