package com.hw4.main;

import java.util.Arrays;
import java.util.concurrent.CompletableFuture;

/**
 *
 * @author lvsho
 */
class ParSort2 {
    public static int cutoff = 1000;
    public static void sort(int[] array, int from, int to) {
    int size = to - from;
    if (size < cutoff) Arrays.sort(array, from, to);
      else {
            int mid = from+(to-from)/2;
            CompletableFuture<int[]> parsort1 = parsort(array, from, mid); // TODO implement me
            CompletableFuture<int[]> parsort2 = parsort(array, mid+1,to); // TODO implement me
            CompletableFuture<int[]> parsort = parsort1.
                    thenCombine(parsort2, (xs1, xs2) -> {
                    int[] result = new int[xs1.length + xs2.length];
                    int p=0,q=0;
                    for(int i=0;i<result.length;i++)
                    {
                      if(p>xs1.length-1) result[i]=xs2[q++];
                      else if(q>xs2.length-1) result[i]=xs1[p++];
                      else if(xs1[p]<xs2[q]) result[i]=xs1[p++];
                      else result[i]=xs2[q++];
                    }// TODO implement me
                     return result;
            });
            parsort.whenComplete((result, throwable) -> {
            for(int i=0;i<array.length;i++)
                array[i]=result[i];}); // TODO implement me
            parsort.join();
        }
  }
 private static CompletableFuture<int[]> parsort(int[] array, int from, int to) {
       return CompletableFuture.supplyAsync(
                   () -> {
             int[] result = new int[to  - from];
             int j = from;
             for(int i=0;i<result.length;i++)
             {
                 result[i]=array[j++];
             }
                       sort(result,0,result.length);
                // TODO implement me
             return result;
 }
);
}

}