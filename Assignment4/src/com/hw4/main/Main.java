package com.hw4.main;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;


public class Main {

    public static void main(String[] args) {
        //timeSortByCutoff();
        timeParSort();
    }

    public static void timeParSort() {
        long[] time = new long[100];
        int[] cutoffArray = new int[100];
        int index = 0;
        
        // instatiate parsort
        ParSort parSort = new ParSort();

        // Expierment:
        for (int cutoff = 10; cutoff < 2000; cutoff = cutoff + 20) {
            System.out.println("Cutoff " + cutoff + " Start:");
            cutoffArray[index] = cutoff;
            time[index++] = parSort.getAverageRuntime(cutoff);
            System.out.println(String.valueOf(time[index-1]));
        }

        // export data
        try {
            File file = new File("d:\\Assignment4.txt");
            FileWriter out = new FileWriter(file,true);
            for (int i = 0; i < time.length; i++) {
                out.write(String.valueOf(cutoffArray[i]));
                out.write(" ");
                out.write(String.valueOf(time[i]));
                out.write("\n");
            }
            out.close();
        } catch (IOException o) {
            o.getStackTrace();
        } 
    }
}