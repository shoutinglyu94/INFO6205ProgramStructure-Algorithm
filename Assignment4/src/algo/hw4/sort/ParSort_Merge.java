package algo.hw4.sort;

import static algo.hw4.sort.ParSort_Quick.randomShuffle;
import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.CompletableFuture;

/**
 *
 * @author lvsho,liuch
 */
public class ParSort_Merge {

    public static int cutoff = 1000;
    
    /**
     * Run sort() 50 times to sort a random generated array with 2000000 size and return average running time
     * @param cutoff_test
     * @return
     */
    public long getAverageRuntime(int cutoff_test) {
        cutoff = cutoff_test;
        long[] time = new long[100];
        int[] array = new int[2000000];
        Random random = new Random(0L);
        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt(10000);
        }
        for (int k = 0; k < 50; k++) {
            randomShuffle(array, 0, array.length);
            long startTime = System.nanoTime();
            sort(array, 0, array.length - 1);
            long finishTime = System.nanoTime();
            time[k] = finishTime - startTime;
        }
        long total = 0L;
        for (long timeitem : time) {
            total = total + timeitem;
        }
        long average = total / 50L;
        //System.out.println("Average Time= " + average);
        return average;
    }

    public static void sort(int[] array, int from, int to) {
        int size = to - from;
        if (size < cutoff) {
            Arrays.sort(array, from, to + 1);
        } else {
            int mid = from + (to - from) / 2;
            CompletableFuture<int[]> parsort1 = parsort(array, from, mid); // TODO implement me
            CompletableFuture<int[]> parsort2 = parsort(array, mid + 1, to); // TODO implement me
            CompletableFuture<int[]> parsort = parsort1.
                    thenCombine(parsort2, (xs1, xs2) -> {
                        int[] result = new int[xs1.length + xs2.length];
                        int p = 0, q = 0;
                        for (int i = 0; i < result.length; i++) {
                            if (p > xs1.length - 1) {
                                result[i] = xs2[q++];
                            } else if (q > xs2.length - 1) {
                                result[i] = xs1[p++];
                            } else if (xs1[p] < xs2[q]) {
                                result[i] = xs1[p++];
                            } else {
                                result[i] = xs2[q++];
                            }
                        }// TODO implement me
                        return result;
                    });
            parsort.whenComplete((result, throwable) -> {
                for (int i = 0; i < array.length; i++) {
                    array[i] = result[i];
                }
            }); // TODO implement me
            parsort.join();
        }
    }

    private static CompletableFuture<int[]> parsort(int[] array, int from, int to) {
        return CompletableFuture.supplyAsync(
                () -> {
                    int[] result = new int[to - from + 1];
                    int j = from;
                    for (int i = 0; i < result.length; i++) {
                        result[i] = array[j++];
                    }
                    sort(result, 0, result.length - 1);
                    return result;
                }
        );
    }

}
