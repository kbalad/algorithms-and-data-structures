package algorithm.common.maxsubarray;

import algorithm.common.maxsubarray.DivideAndConquerMaxSubarray.ArrInfo;
import java.util.Random;

/**
 * Determine array size when brute force become worse than d&c.
 *
 * <p>The algorithm is following: to determine {@code N} we iterate through every size {@code
 * 1..MAX_N} of an array each time doing following things:</p>
 *
 * <p>To get mean time on every size-iteration, we make a computation for one size for {@code
 * K_ITER} times, after which we mean computed values:
 * <ol>
 * <li>Generate an array with random int numbers from {@code 0..(MAX_N-1)}</li>
 * <li>Measure brute force execution time, measure divide-and-conquer execution time</li>
 * </ol>
 * </p>
 *
 * <p>After that we iterate through array of measured times for different sizes from {@code 1} to {@code MAX_N}
 * and compare: if bruteForce ex.time is more than d&c ex.time for {@code THRESHOLD} in row,
 * than we found that {@code N}.</p>
 * <p>Note: here we make an assumption that computation time complexity of these functions are not
 * of the same polynomial power: {@code O(n^2) > O(n*lg(n))}.</p>
 *
 * <p>All of these previous steps are iterated for {@code TOTAL_N_COMPUTATIONS} times, and we mean {@code N}.
 *
 * <p>For MAX_N=500, K_ITER=10, TOTAL_N_COMPUTATIONS=10, THRESHOLD=20 {@code N=149} on my computer.</p>
 *
 * @author BaladKV
 * @since 12.05.2020
 */
public class ComplexMaxSubarrayAnalysis {

    private static final int MAX_N = 500; // max size of arr
    private static final int K_ITER = 10; // times of repetitive tests with one size to get mean execution time
    private static final int TOTAL_N_COMPUTATIONS = 10; // determine mean N from all computations
    public static final int THRESHOLD = 20; // threshold to determine that brute force is slower

    public static void main(String[] args) {
        int n = measureMeanN();
        System.out.println("N=" + n);
    }

    private static int measureMeanN() {
        int n = 0;
        for (int i = 0; i < TOTAL_N_COMPUTATIONS; i++) {
            double[] meanBrute = new double[MAX_N];
            double[] meanDivide = new double[MAX_N];
            measure(meanBrute, meanDivide);
            n += findN(meanBrute, meanDivide);
        }
        return n / TOTAL_N_COMPUTATIONS;
    }

    private static int findN(double[] meanBrute, double[] meanDivide) {
        int cnt = 0;
        for (int i = 1; i < meanBrute.length; i++) {
            if (meanBrute[i] >= meanDivide[i]) {
                cnt++;
                if (cnt == THRESHOLD) {
                    return i - cnt + 1;
                }
            } else {
                cnt = 0;
            }
        }
        return -1;
    }

    private static void measure(double[] meanBrute, double[] meanDivide) {
        for (int i = 0; i < MAX_N; i++) {
            double bruteTime = 0;
            double divideTime = 0;
            for (int j = 0; j < K_ITER; j++) {
                int[] a = generateArray(i + 1);
                bruteTime += measureBrute(a);
                divideTime += measureDivide(a);
            }
            meanBrute[i] = bruteTime / K_ITER;
            meanDivide[i] = divideTime / K_ITER;
        }
    }

    private static double measureDivide(int[] a) {
        long s = System.nanoTime();
        DivideAndConquerMaxSubarray.divideAndConquerFindMaxSubarray(a, new ArrInfo(0, a.length, 0));
        long e = System.nanoTime();
        return e - s;
    }

    private static double measureBrute(int[] a) {
        long s = System.nanoTime();
        BruteForceMaxSubarray.bruteForceFindMaxSubarray(a);
        long e = System.nanoTime();
        return e - s;
    }

    private static int[] generateArray(int size) {
        Random rnd = new Random();
        int[] ret = new int[size];
        for (int i = 0; i < size; i++) {
            ret[i] = rnd.nextInt(size);
        }
        return ret;
    }

}
