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
public class b {
     public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        int n = cin.nextInt();
        int k = cin.nextInt();
        int x;
        int y;
        int count=0;
        for(x=1;x<=n;x++){
            for(y=1;y<=n;y++){
                if(x%y>=k)count++;
            }
        }
        System.out.println(count);
     }
}
