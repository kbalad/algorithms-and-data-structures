package hackerrank.greedy;

import java.util.Arrays;

public class MinimumAbsolutDifferenceInAnArray {

    private final int[] array;

    public MinimumAbsolutDifferenceInAnArray(int[] array) {
        this.array = Arrays.copyOf(array, array.length);
    }

    public int routine() {
        Arrays.sort(array);
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < array.length - 1; i++) {
            int diff = Math.abs(array[i] - array[i+1]);
            if (diff < min) {
                min = diff;
            }
        }
        return min;
    }

}
