package com.hw4.main;

import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.CompletableFuture;

class ParSort {

    public static int cutoff;

    public static void getAverageRuntime(int cutoff_test) {
        cutoff = cutoff_test;
        System.out.println("Optimal Cutoff: " + cutoff);
        long[] time = new long[100];
        for (int k = 0; k < 100; k++) {
            Random random = new Random(0L);
            int[] array = new int[2000];
            for (int i = 0; i < array.length; i++) {
                array[i] = random.nextInt(10000);
            }
            long startTime = System.nanoTime();
            sort(array, 0, array.length - 1);
            long finishTime = System.nanoTime();
            time[k] = finishTime - startTime;
        }
        long total = 0;
        for (long timeitem : time) {
            total = total + timeitem;
        }
        long average = total / 100;
        System.out.println("Average Time= " + average);
    }

    public static void sort(int[] array, int from, int to) {
        int size = to - from;
        if (size < cutoff) {
            Arrays.sort(array, from, to+1);
        } else {
            int pivot = partition(array, from, to);
            //in case pivot is from or to
            while (pivot == from || pivot == to) {
                randomShuffle(array, from, to);
                pivot = partition(array, from, to);
            }

            CompletableFuture<int[]> parsort1 = parsort(array, from, pivot - 1); // TODO implement me
            CompletableFuture<int[]> parsort2 = parsort(array, pivot + 1, to); // TODO implement me
            CompletableFuture<int[]> parsort = parsort1.
                    thenCombine(parsort2, (xs1, xs2) -> {
                        int result[] = new int[xs1.length + xs2.length + 1];
                        System.arraycopy(xs1, 0, result, 0, xs1.length);
                        result[xs1.length] = array[xs1.length];
                        System.arraycopy(xs2, 0, result, xs1.length + 1, xs2.length);
                        return result;
                    });

            parsort.whenComplete((int[] result, Throwable throwable) -> {
                System.arraycopy(result, 0, array, from, result.length);
            });
            parsort.join();

        }
    }

    private static CompletableFuture<int[]> parsort(int[] array, int from, int to) {
        return CompletableFuture.supplyAsync(
                () -> {
                    //System.out.println("Sort from " + from + " to " + to);
                    int[] result = new int[to - from + 1];
                    System.arraycopy(array, from, result, 0, result.length);
                    sort(result, 0, result.length-1);
                    return result;
                }
        );
    }


    private static int partition(int[] xs, int lo, int hi) {
        int i = lo;
        int j = hi+1;
        while (true) {
            while (less(xs[++i], xs[lo])) {
                if (i == hi) {
                    break;
                }
            }
            while (less(xs[lo], xs[--j])) {
                if (j == lo) {
                    break;
                }
            }
            if (i >= j) {
                break;
            }
            swap(xs, i, j);
        }
        swap(xs, lo, j);

        return j;
    }

    public static <X extends Comparable<X>> boolean less(X v, X w) {
        return v.compareTo(w) < 0;
    }

    public static void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    public static void randomShuffle(int[] a, int start, int end) {
        for (int i = start; i < end; i++) {
            int j = new Random().nextInt(i + 1);
            swap(a, i, j);
        }
    }
}
