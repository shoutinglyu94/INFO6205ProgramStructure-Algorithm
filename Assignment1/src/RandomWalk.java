

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import java.util.ArrayList;
import java.util.Random;
import javax.swing.JPanel;

public class RandomWalk extends JPanel {

    private int x = 0;
    private int y = 0;

    public void move(int dx, int dy) {
        this.x += dx;
        this.y += dy;
    }

    public void returnZero() {
        this.x = 0;
        this.y = 0;
    }

    public ArrayList<Double[]> randomWalk(int n, int L) {
        Random chooser = new Random();
        ArrayList<Double[]> resultList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            Double[] result = new Double[3];
            double randomDirection = chooser.nextDouble();
            if (randomDirection >= 0 && randomDirection < 0.25) {
                move(L, 0);
            } else if (randomDirection >= 0.25 && randomDirection < 0.5) {
                move(0, L);
            } else if (randomDirection >= 0.5 && randomDirection < 0.75) {
                move(-L, 0);
            } else if (randomDirection >= 0.75 && randomDirection < 1.0) {
                move(0, -L);
            }
            double a = this.x;
            double b = this.y;
            result[0] = a;
            result[1] = b;
            result[2] = distance();
            resultList.add(result);
        }
        return resultList;
    }

    public double distance() {
        double a = this.x;
        double b = this.y;
        return Math.sqrt(Math.pow(a, 2) + Math.pow(b, 2));  // TODO you need to implement this
    }

    public static void main(String[] args) {

        ArrayList<ArrayList<Double[]>> testList = new ArrayList<>();
        //JUnit Test
        RandomWalkTest.testMove1();
        RandomWalkTest.testMove2();
        RandomWalkTest.testMove3();
        RandomWalkTest.testRandomWalk();
        // Writing Result
        int times = 10;
        for (int i = 0; i < 10; i++) {
            System.out.println("Test" + i + ": n=" + times + "\n");
            for (int j = 0; j < 5; j++) {
                RandomWalk randomTest = new RandomWalk();
                try {
                    File file = new File("d:\\test_" +(i+1)+ "_n_" +times+".txt"); 
                    FileWriter out = new FileWriter(file,true);   
                    for (Double[] test1 : randomTest.randomWalk(times, 16)) {
                        out.write(test1[0] + " ");
                        out.write(test1[1] + " ");
                        out.write(test1[2] + "\n");
                    }
                    out.close();
                } catch (IOException o) {
                    o.getStackTrace();
                }
            }
            times = times*2;
        }

    }

}
