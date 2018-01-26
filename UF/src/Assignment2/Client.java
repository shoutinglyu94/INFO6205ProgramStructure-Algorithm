/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Assignment2;

import java.util.Scanner;

/**
 *
 * @author lvsho
 */
public class Client {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        System.out.println("Please enter a integer which determines the number of \"sites\".");
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int connection = WQUPC.count(n);
        System.out.println("Final number of connection is:" + connection);

    }

}
