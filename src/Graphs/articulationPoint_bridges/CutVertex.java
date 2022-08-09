package com.practice.Graphs.articulationPoint_bridges;

import java.util.ArrayList;

class CutVertexImpl{
    int time=0;
    int v;
    ArrayList<ArrayList<Integer>> adj=new ArrayList<ArrayList<Integer>>();
    CutVertexImpl(int v){
        this.v=v;
        for(int i=0;i<v;i++)
            adj.add(new ArrayList<>());
    }
    public void addEdge(int u, int v)
    {
        adj.get(u).add(v);
        adj.get(v).add(u);
    }
    public void dfs(int u,int disc[], int low[],int parent[],boolean[] articulationPoint){
        disc[u]=low[u]=time;
        time+=1;
        int children=0;
        for(int v:adj.get(u)){
            if(disc[v]==-1)
            {
                children+=1;
                parent[v]=u;
                dfs(v,disc,low,parent,articulationPoint);
                low[u]=Math.min(low[u],low[v]);

                if(parent[u]==-1 && children>1)
                    articulationPoint[u]=true;

                if(parent[u]!=-1 && low[v]>=disc[u])
                    articulationPoint[u]=true;
            }
            else if(v!=parent[u])
                low[u]=Math.min(low[u],disc[v]);
        }
    }
    public void findAP_Tarjan(){
        int low[]=new int[v];
        int disc[]=new int[v];
        boolean articulationPoint[]=new boolean[v];
        int parent[]=new int[v];
        for(int i=0;i<v;i++){
            disc[i]=-1;
            low[i]=-1;
        }
        for(int i=0;i<v;i++){
            if(disc[i]==-1)
                dfs(i,disc,low,parent,articulationPoint);
        }
        for(int i=0;i<v;i++)
        {
            if (articulationPoint[i]) {
                System.out.println(i);
            }
        }
    }
}
public class CutVertex {
    public static void main(String[] args) {
        CutVertexImpl g=new CutVertexImpl(6);
        g.addEdge(0,1);
        g.addEdge(0,2);
        g.addEdge(1,2);
        g.addEdge(0,3);
        g.addEdge(3,4);
        g.addEdge(3,5);
        g.findAP_Tarjan();
    }
}
