/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package saima;

import java.util.Scanner;

/**
 *
 * @author lvsho
 */
public class c {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        int N = cin.nextInt();
        int M = cin.nextInt();
        int[] D = new int[N];
        int[] P = new int [N];
        int [] A = new int[M];   
        int [] Pay = new int [M];
        for(int i =0;i<N;i++){
            D[i] = cin.nextInt();
            P[i] = cin.nextInt();
        }
        for(int i=0;i<M;i++){
            A[i] = cin.nextInt();
        }
        for(int i=0;i<M;i++){
            for(int j=0;j<N;j++){
                if(A[i]>D[j]) Pay[i] += P[j];
            }   
            System.out.println(Pay[i]);
        }
        
        
     }
}
