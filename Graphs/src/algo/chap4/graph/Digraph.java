/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algo.chap4.graph;

import edu.princeton.cs.algs4.In;

/**
 *
 * @author lvsho
 */
public class Digraph {
     private final int V;
    private int E;
    private Bag_Array<Integer>[] adj;
    
    public Digraph(int V){
        this.V = V;
        this.E = 0;
        adj = (Bag_Array<Integer>[])new Bag_Array[V];
        for(int v=0;v<V;v++)
            adj[v] = new Bag_Array<>();
    }
    
    public Digraph(In in){
        this(in.readInt());
        int E = in.readInt();
        for(int i=0;i<E;i++){
            int v =in.readInt();
            int w = in.readInt();
            addEdge(v,w);
        }
    }
    
    public int V(){return V;}
    public int E(){return E;}
    
    public void addEdge(int v,int w){
        adj[v].add(w);
        E++;
    }
    
    public Iterable<Integer> adj(int v){
        return adj[v];
    }
    
    public Digraph reverse(){
        Digraph R = new Digraph(V);
        for(int v=0;v<V;v++)
            for(int w:adj(v))
                R.addEdge(w, v);
        return R;
    }
    @Override
    public String toString(){
        String s = V +" vertices, " + E + " edges\n";
        for(int v=0;v<V;v++){
            s += v + ": ";
            for(int w:this.adj(v))
                s+= w +" ";
            s += "\n";
        }
        return s;
    }
    
}
