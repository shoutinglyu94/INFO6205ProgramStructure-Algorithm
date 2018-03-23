
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package saima;

import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author lvsho
 */
public class a {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        String str = cin.nextLine();
        char[] sChar = str.toCharArray();
        Arrays.sort(sChar);
        int L = sChar.length;
        char[] all = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};
        for (int i = 0; i < L; i++) {
            for (int j = 0; j < 10; j++) {
                if (sChar[i] == all[j]) {
                    all[j] = 'N';
                }
            }
        }
        int count = 0;
        for (int i = 0; i < 10; i++) {
            if (all[i] == 'N') {
                count++;
            }
        }
        char[] newChar = new char[10 - count];
        boolean hasZero = false;
        int zerocount = 0;
        int Ncount = 0;
        int i=0;
        for (int j = 0; j < 10; j++) {
            if (all[j] != 'N') {
                newChar[i++] = all[j];
                Ncount++;
            }
            if (all[j] == '0') {
                hasZero = true;
                zerocount++;
            }
        }

        if (hasZero == true) {
            if(zerocount + count != 10){
                System.out.println(newChar);
            }else {
                String a = String.valueOf(sChar[0]);
                System.out.println(Integer.parseInt(a)*10);
            }
            
        } else if (hasZero == false) {
            Arrays.sort(newChar);
            System.out.println(newChar[0]);
        } 
    }
}
