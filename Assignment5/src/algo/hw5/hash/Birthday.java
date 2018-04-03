/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algo.hw5.hash;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author lvsho
 */
public class Birthday {

    public static int hash(int key, int p) {
        return key % p;
    }

    public static double bFunction(int M) {
        return Math.sqrt(Math.PI * M / 2);
    }

    public static double cFunction(int M) {
        return Math.log1p(M) * M;
    }

    public static int birthdayExperiment(int M, int birthdayHash) {
        int[] array1 = new int[M];
        for (int i = 0; i < M; i++) {
            array1[i] = 0;
        }
        Random chooser = new Random();
        int index;
        int key;

        while (true) {
            key = chooser.nextInt(Integer.MAX_VALUE);
            index = hash(key, M);
            if (index < M) {
                if (array1[index] == 0) {
                    array1[index] = 1;
                } else {
                    break;
                }
            }

            birthdayHash++;
        }

        return birthdayHash;
    }

    public static int cardExperiment(int M, int cardHash) {
        int[] array2 = new int[M];
        for (int i = 0; i < M; i++) {
            array2[i] = 0;
        }
        Random chooser = new Random();
        int index;
        int key;

        boolean complete;

        while (true) {
            key = chooser.nextInt(Integer.MAX_VALUE);
            index = hash(key, M);
            if (index < M) {
                array2[index] = 1;
            }
            cardHash++;
            complete = true;
            for (int i = 0; i < M; i++) {
                if (array2[i] == 0) {
                    complete = false;
                    break;
                }
            }
            if (complete == true) {
                break;
            }
        }
        return cardHash;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[][] cardHashArray = new int[100][6];
        int[][] birthdayHashArray = new int[100][6]; 
        int cardHash,birthdayHash;
        System.out.println("-----------------------------------");
        System.out.println("Please enter the size of the array:");
        int size = scanner.nextInt();
        int M;
        
        // For each array size M do 100 times experiment
        for (int i = 0; i < 100; i++) {
            M = size;
            for (int j = 0; j < 6; j++) {
                M = M * 2;
                cardHash=0;
                birthdayHash =0;
                //Birthday Experiment
                birthdayHashArray[i][j] = birthdayExperiment(M, birthdayHash);

                //Collecting Cards
                cardHashArray[i][j] = cardExperiment(M, cardHash);

            }
        }
        
        // Caculate the average hash times
        int[] averageBirthday = new int[6];
        int[] averageCard = new int [6];
        for(int i=0;i<100;i++){
            for(int j=0;j<6;j++){
                averageBirthday[j] += birthdayHashArray[i][j];
                averageCard[j] += cardHashArray[i][j]; 
            }
        }
        int arraySize=size;
        // print out the result
        for(int i=0;i<6;i++){
            arraySize*=2;
            System.out.println("M=" + arraySize);
            System.out.println("birth: " + averageBirthday[i] / 100.0 + ", card: " + averageCard[i] / 100.0);
            System.out.println("birth_theory: " + bFunction(arraySize)+ ", card_theory: " + cFunction(arraySize));
        }

    }

}
