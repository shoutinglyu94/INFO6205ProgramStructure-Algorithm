/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algo.chap4.graph;

/**
 *
 * @author lvsho
 */
public class DepthFirstSearch {
    private boolean[] marked;
    private int count;
    
    public DepthFirstSearch(Graph G,int s){
        marked = new boolean[G.V()];
        dfs(G,s);
    }
    
    private void dfs(Graph G,int v){
        marked[v] = true;
        count++;
        for(int w: G.adj(v))
            if(!marked[w]) dfs(G,w);    
    }
    
    public boolean marked(int w){
        return marked[w];
    }
    
    public int count(){
        return count;
    }
}
