/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hw4.main;

import java.util.Random;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author lvsho
 */
public class ParSortTest {
    
    public ParSortTest() {
    }


    /**
     * Test of sort method, of class ParSort.
     */
    @Test
    public void testSort() {
        System.out.println("Test sort():");
        
        // Generate Random Test Sample
        int[] array = new int[100];
        Random random = new Random();
        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt(1000);
        }
        
        // Initiate ParSort
        ParSort parsort = new ParSort();
        parsort.cutoff = 10;
        
        // Sort
        ParSort.sort(array, 0, array.length-1);
        
        // Check 
        for (int i = 0; i < array.length - 1; i++) {
            System.out.println(array[i]);
            assertTrue(array[i] <= array[i + 1]);
        }
    }


    
}
