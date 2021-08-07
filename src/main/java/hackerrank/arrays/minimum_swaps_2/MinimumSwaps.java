package hackerrank.arrays.minimum_swaps_2;

public class MinimumSwaps {

    public MinimumSwaps(int[] input) {
        initElements(input);
        initPos();
    }

    private int[] elements; // start from index == 1
    private int[] pos;
    private int swapsCnt = 0;

    public int routine() {
        for (int i = 1; i < elements.length; i++) {
            if (elements[i] != i) {
                int oldIndexBeforeModification = elements[i];
                swap(elements, i, pos[i]);
                swap(pos, i ,oldIndexBeforeModification);
                swapsCnt++;
            }
        }
        return swapsCnt;
    }

    private void swap(int[] a, int i, int j) {
        int x = a[i];
        a[i] = a[j];
        a[j] = x;
    }

    private void initElements(int[] input) {
        int len = input.length;
        elements = new int[len + 1];
        System.arraycopy(input, 0, elements, 1, len);
    }

    private void initPos() {
        int len = elements.length;
        pos = new int[len];
        for (int i = 1; i < len; i++) {
            pos[elements[i]] = i;
        }
    }

}
