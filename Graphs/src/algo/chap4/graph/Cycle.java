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
public class Cycle {
    private boolean[] marked;
    private boolean hasCycle;
    public Cycle(Graph G){
        marked = new boolean[G.V()];
        for(int s=0;s<G.V();s++)
            if(!marked[s])
                dfs(G,s,s);
    }
    
    private void dfs(Graph G, int v, int u){
        marked[v] =true;
        for(int w:G.adj(v))
            if(!marked[w])
                dfs(G,w,v);
            else if(w!=u) hasCycle =true;
    }
    
    public boolean hashCycle(){
        return hasCycle;
    }
}
