/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hw4.main;

import java.util.Random;

/**
 *
 * @author lvsho
 */
public class Main2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // if (args.length>0) ParSort.cutoff = Integer.parseInt(args[0]);
        for (int cutoff = 10; cutoff < 2000; cutoff = cutoff + 20) {
            long[] time = new long[200];
            for (int k = 0; k < 200; k++) {
                ParSort parSort = new ParSort();
                parSort.cutoff = cutoff;
                Random random = new Random(0L);
                int[] array = new int[2000];
                for (int i = 0; i < array.length; i++) {
                    array[i] = random.nextInt(10000);
                }
                long startTime = System.nanoTime();
                ParSort.sort(array, 0, array.length);
                long finishTime = System.nanoTime();
                time[k] = finishTime - startTime;
                // if (array[0]==11) System.out.println("Success!");
            }
            long total = 0;
            for (long timeitem : time) {
                total = total + timeitem;
            }
            long average = total / 200;
            System.out.println(average);
            //  System.out.println("cutoff"+cutoff+"took time"+(finishTime-startTime));
        }
    }
}
