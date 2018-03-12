/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Assignment2;

import java.util.Random;

/**
 *
 * @author lvsho
 */
public class QuickFind {
    private int[] parent;   // parent[i] = parent of i
    private int[] size;   // size[i] = size of subtree rooted at i
    private int count;  // number of components
    
    public QuickFind(int n){
        count = n;
        parent = new int[n];
        size = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
            size[i] = 1;
        }
    }
    
    public void show() {
        for (int i = 0; i < parent.length; i++) {
            System.out.printf("%d: %d, %d\n", i, parent[i], size[i]);
        }
    }

    /**
     * Returns the number of components.
     *
     * @param n number of sites
     * @return the number of components (between {@code 1} and {@code n})
     */
    public static int count(int n) {
        QuickFind qf = new QuickFind(n);
        int pairs = 0;
        boolean complete = false;
        while (complete == false) {
            Random chooser = new Random();
            int a = chooser.nextInt(n);
            int b = chooser.nextInt(n);
            pairs++;
            if (qf.connected(a, b)) {
            } else {
                qf.union(a, b);
            }
            complete = true;
            for (int k = 0; k < n - 1; k++) {
                if (!qf.connected(k, 0)) {
                    complete = false;
                    break;
                }
            }
        }
        return pairs;
    }

    /**
     * Returns the component identifier for the component containing site
     * {@code p}.
     *
     * @param p the integer representing one site
     * @return the component identifier for the component containing site
     * {@code p}
     * @throws IllegalArgumentException unless {@code 0 <= p < n}
     */
    public int find(int p) {
        return parent[p];
    }

    // validate that p is a valid index
    private void validate(int p) {
        int n = parent.length;
        if (p < 0 || p >= n) {
            throw new IllegalArgumentException("index " + p + " is not between 0 and " + (n - 1));
        }
    }

    /**
     * Returns true if the the two sites are in the same component.
     *
     * @param p the integer representing one site
     * @param q the integer representing the other site
     * @return {@code true} if the two sites {@code p} and {@code q} are in the
     * same component; {@code false} otherwise
     * @throws IllegalArgumentException unless both {@code 0 <= p < n} and
     * {@code 0 <= q < n}
     */
    public boolean connected(int p, int q) {
        return find(p) == find(q);
    }

    /**
     * Merges the component containing site {@code p} with the the component
     * containing site {@code q}.
     *
     * @param p the integer representing one site
     * @param q the integer representing the other site
     * @throws IllegalArgumentException unless both {@code 0 <= p < n} and
     * {@code 0 <= q < n}
     */
    public void union(int p, int q) {
        int pRoot = find(p);
        int qRoot = find(q);
        
        if(pRoot==qRoot) return;

        for(int i=0;i<parent.length;i++){
            if(parent[i]==pRoot){
                parent[i] = qRoot;
            }
        }
        count--;

    }

}
