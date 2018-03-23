/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package saima;

import java.io.*;
import java.util.*;
/**
 *
 * @author lvsho
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        String S,T;
        S = cin.nextLine();
        T = cin.nextLine();
        char[] sChar = S.toCharArray();
        char[] tChar = T.toCharArray();
        int n = sChar.length-tChar.length+1;
        int result=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<tChar.length;j++){
                if( tChar[j]== sChar[j+i])result++;
            }
        }
        
        
        System.out.print(result);
     }
}
