/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Assignment2;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
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
        try {
            File file = new File("d:\\Assignment2.txt");
            FileWriter out = new FileWriter(file, true);
            
            for (int i=0;i<20;i++) {
                int sites = (int) (n+i*50);
                out.write(sites+ " ");
                out.write(WQUPC.count(sites) + "\n");
            }
            out.close();
        } catch (IOException o) {
            o.getStackTrace();
        }

    }

}
