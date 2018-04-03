/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algo.chap4.graph;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;



/**
 *
 * @author lvsho
 */
public class BreadthFirstPaths {
    private boolean[] marked;
    private int[] edgeTo;
    private final int s;
    
    public BreadthFirstPaths(Graph G,int s){
        marked = new boolean[G.V()];
        edgeTo = new int [G.V()];
        this.s =s;
        bfs(G,s);
    }
    
    public void bfs(Graph G, int s){
        Queue<Integer> queue = new LinkedList<Integer>();
        marked[s] = true;
        queue.offer(s);
        while(!queue.isEmpty()){
            int v = queue.poll();
            for(int w: G.adj(v))
                if(!marked[w]){
                    edgeTo[w] = v;
                    marked[w] = true;
                    queue.offer(w);
                }
        }
    }
    
    public boolean hasPathTo(int v){
        return marked[v];
    }
    
    public Iterable<Integer> pathTo(int v){
        if(!hasPathTo(v)) return null;
        Stack<Integer> path = new Stack();
        for(int x =v;x!=s;x =edgeTo[x]){
            path.push(x);
        }
        path.push(s);
        return path;
    }
}
