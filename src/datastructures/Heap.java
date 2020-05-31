package datastructures;

import java.util.Arrays;

/**
 * Dummy heap | set, represented by binary tree backed by one-dimensional array.
 *
 * @author BaladKV
 * @since 31.05.2020
 */

public class Heap {

    private int size;
    private final int[] a;

    private Heap(int[] a) {
        this.a = a;
        this.size = a.length;
    }

    public static datastructures.Heap buildMaxHeap(int[] a) {
        datastructures.Heap h = new datastructures.Heap(a);
        for (int i = a.length / 2; i >= 0; i--) {
            h.maxHeapify(i);
        }
        return h;
    }

    public void maxHeapify(int ind) {
        int l = left(ind);
        int r = right(ind);
        int maxInd = ind;
        if (l < size && a[l] > a[ind]) {
            maxInd = l;
        }
        if (r < size && a[r] > a[maxInd]) {
            maxInd = r;
        }
        if (maxInd != ind) {
            swap(ind, maxInd);
            maxHeapify(maxInd);
        }
    }

    public static void heapsort(int[] a) {
        datastructures.Heap h = datastructures.Heap.buildMaxHeap(a);
        for (int i = h.size - 1; i >= 0; i--) {
            h.swap(i, 0);
            h.size--;
            h.maxHeapify(0);
        }
    }

    @Override
    public String toString() {
        return Arrays.toString(a);
    }

    public int[] getA() {
        return a;
    }

    private int left(int i) {
        return i * 2;
    }

    private int right(int i) {
        return i * 2 + 1;
    }

    private void swap(int i, int j) {
        int w = a[i];
        a[i] = a[j];
        a[j] = w;
    }
}
