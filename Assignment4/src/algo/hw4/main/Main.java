package algo.hw4.main;

import algo.hw4.sort.ParSort_Merge;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author lvsho,liuch
 */
public class Main {

    /**
     * Read a customized cutoff for the algorithm and output the average time for that
     * @param args
     */
    public static void main(String[] args) {
        System.out.println("Please enter a integer which determines the cutoff of the Parallel Sorting Algorithm:");
        Scanner in = new Scanner(System.in);
        int cutoff = in.nextInt();
        ParSort_Merge parsort = new ParSort_Merge();
        System.out.println("The average running time used to sort a 2000000 elements array is: ");
        System.out.print(parsort.getAverageRuntime(cutoff));
        //timeMergeParSort_IncreaseCutoff();
        //timeMergeParSort_DivideCutoff();
    }

    /**
     * Experiment using ParSort_Merge
     * Increase the Cutoff from 10000 to 2000000
     * Output the data into a txt file
     */
    public static void timeMergeParSort_IncreaseCutoff() {
        long[] time = new long[200];
        int[] cutoffArray = new int[200];
        int index = 0;
        ParSort_Merge parsort = new ParSort_Merge();

        for (int cutoff = 10000; cutoff < 2000000; cutoff = cutoff + 10000) {
            System.out.println("Cutoff " + cutoff + " Start:");
            cutoffArray[index] = cutoff;
            time[index++] = parsort.getAverageRuntime(cutoff);
            System.out.println(String.valueOf(time[index - 1]));
        }

        // export data
        try {
            File file = new File("d:\\Assignment4-quick-2000k.txt");
            FileWriter out = new FileWriter(file, true);
            for (int i = 0; i < time.length; i++) {
                out.write(String.valueOf(cutoffArray[i]));
                out.write(",");
                out.write(String.valueOf(time[i]));
                out.write("\n");
            }
            out.close();
        } catch (IOException o) {
            o.getStackTrace();
        }
    }

    /**
     * Experiment using ParSort_Merge
     * Changing the Cutoff by dividing from 2000000 to 4000
     * Output the data into a txt file
     */
    public static void timeMergeParSort_DivideCutoff() {
        long[] time = new long[9];
        int[] cutoffArray = new int[9];
        int index = 0;

        // instatiate parsort
        ParSort_Merge parSort = new ParSort_Merge();

        // Expierment:
        for (int cutoff = 2000000; cutoff > 4000; cutoff = cutoff / 2) {
            System.out.println("Cutoff " + cutoff + " Start:");
            cutoffArray[index] = cutoff;
            time[index++] = parSort.getAverageRuntime(cutoff);
            System.out.println(String.valueOf(time[index - 1]));
        }

        // export data
        try {
            File file = new File("d:\\Assignment4-quick-divide.txt");
            FileWriter out = new FileWriter(file, true);
            for (int i = 0; i < time.length; i++) {
                out.write(String.valueOf(cutoffArray[i]));
                out.write(",");
                out.write(String.valueOf(time[i]));
                out.write("\n");
            }
            out.close();
        } catch (IOException o) {
            o.getStackTrace();
        }
    }

}
