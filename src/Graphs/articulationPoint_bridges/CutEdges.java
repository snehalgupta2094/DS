package com.practice.Graphs.articulationPoint_bridges;

import java.util.ArrayList;

class Pair{
    int u,v;
    Pair(int u, int v){
        this.u=u;
        this.v=v;
    }
}
class CutEdgesImpl{
    int time=0;
    ArrayList<ArrayList<Integer>> adj=new ArrayList<ArrayList<Integer>>();
    int v;
    CutEdgesImpl(int v){
        this.v=v;
        for(int i=0;i<v;i++)
            adj.add(new ArrayList<>());
    }
    public void addEdge(int u, int v)
    {
        adj.get(u).add(v);
        adj.get(v).add(u);
    }
    public void dfs(int u, int disc[], int low[], int parent[], ArrayList<Pair> bridge){

        disc[u]=low[u]=time;
        time+=1;

        for(int v: adj.get(u)){
            if(disc[v]==-1) //if v is not visited
            {
                parent[v]=u;
                dfs(v,disc,low,parent,bridge);
                low[u]=Math.min(low[u],low[v]);

                if(low[v]>disc[u])
                    bridge.add(new Pair(u,v));
            }
            else if(v!=parent[u]){ //ignore child to parent edge
                low[u]=Math.min(low[u],disc[v]);
            }
        }
    }
    public void findBridge_Tarjan(){
        int low[]=new int[v];
        int disc[]=new int[v];
        ArrayList<Pair> bridge=new ArrayList<>();
        int parent[]=new int[v];
        for(int i=0;i<v;i++){
            disc[i]=-1;
            low[i]=-1;
        }
        for(int i=0;i<v;i++){
            if(disc[i]==-1)
                dfs(i,disc,low,parent,bridge);
        }
        for(int i=0;i<bridge.size();i++)
        {
            System.out.println(bridge.get(i).u+","+bridge.get(i).v);
        }
    }
}
public class CutEdges {
    public static void main(String[] args) {
        CutEdgesImpl g=new CutEdgesImpl(5);
        g.addEdge(0,1);
        g.addEdge(0,2);
        g.addEdge(1,2);
        g.addEdge(0,3);
        g.addEdge(3,4);
        g.findBridge_Tarjan();
    }
}
