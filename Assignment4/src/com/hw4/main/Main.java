package com.hw4.main;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class Main {

    public static void main(String[] args) {
        //
        //testParSort();

        timeSortByCutoff();
    }

    public static void testParSort() {
        ParSort parSort = new ParSort();
        parSort.cutoff = 10;
        Random random = new Random(0L);
        int[] array = new int[100];
        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt(100);
        }
        for (int i = 0; i < array.length - 1; i++) {
            System.out.println(array[i]);

        }
        System.out.println("start:");
        ParSort.sort(array, 0, array.length - 1);
        for (int i = 0; i < array.length - 1; i++) {
            System.out.println(array[i]);
            if (array[i] > array[i + 1]) {
                System.out.println(array[i] + " and " + array[i + 1] + "Fail!");
            }
        }

    }


    public static void timeSortByCutoff() {
        
        long[] averageTime = new long[100];
        int[] cutoffArray = new int[100];
        int number_cutoff = 0;
        
        // Generate random array
        Random random = new Random(0L);
        int[] array = new int[2000];
        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt(10000);
        }

        // instatiate parsort
        ParSort parSort = new ParSort();
        
        // Expierment:
        for (int cutoff = 10; cutoff < 2000; cutoff = cutoff + 20) {
            System.out.println("Cutoff " + cutoff + " Start:");
            long[] time = new long[200];
            for (int k = 0; k < 100; k++) {
                parSort.cutoff = cutoff;
                ParSort.randomShuffle(array, 0, array.length);
                long startTime = System.nanoTime();
                parSort.sort(array, 0, array.length - 1);
                long finishTime = System.nanoTime();
                time[k] = finishTime - startTime;
            }
            
            // caculate average time
            long total = 0;
            for (long timeitem : time) {
                total = total + timeitem;
            }
            long average = total / 100;
            System.out.println(average);
            averageTime[number_cutoff] = average;
            cutoffArray[number_cutoff] = cutoff;
            number_cutoff++;
        }

        // export data
        try {
            File file = new File("d:\\Assignment4.txt");
            FileWriter out = new FileWriter(file, true);
            int n = averageTime.length;
            for (int i = 0; i < n; i++) {
                out.write(cutoffArray[i] + " ");
                out.write(averageTime[i] + "\n");
            }
            out.close();
        } catch (IOException o) {
            o.getStackTrace();
        }
    }
}
