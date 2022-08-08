package com.practice.Graphs.cycleDetection;

import java.util.ArrayList;

class DetectCycleDirectedImpl{
    int v;
    ArrayList<ArrayList<Integer>> adj=new ArrayList<ArrayList<Integer>>();
    DetectCycleDirectedImpl(int v){
        this.v=v;
        for(int i=0;i<v;i++)
            adj.add(new ArrayList<>());
    }
    public void addEdge(int u, int v)
    {
        adj.get(u).add(v);
    }

    public boolean[] isCycleExist() {
        boolean visited[]=new boolean[v];
        boolean recStack[]=new boolean[v];
        for(int i=0;i<v;i++)
        {
            if(!visited[i])
                if(dfs(i,visited,recStack))
                {
                    return recStack;
                }

        }
        return recStack;
    }
    public boolean dfs(int u, boolean visited[], boolean recStack[]){
        visited[u]=true;
        recStack[u]=true;
        for(int v:adj.get(u))
        {
            if(!visited[v]){
                if(dfs(v,visited,recStack))
                    return true;
            }else if(recStack[v])
                return true;
        }
        recStack[u]=false;
        return false;
    }

    public void printCycle(){
        boolean[] res=isCycleExist();
        for (int i = 0; i < res.length; i++) {
            if(res[i])
                System.out.println(i);
        }
    }
}
public class DetectCycleDirected {
    public static void main(String[] args) {
/*        DetectCycleDirectedImpl g=new DetectCycleDirectedImpl(6);
        g.addEdge(0,1);
        g.addEdge(2,0);
        g.addEdge(1,2);
        g.addEdge(3,0);
        g.addEdge(3,4);
        g.addEdge(4,5);
        g.printCycle();*/
        DetectCycleDirectedImpl g=new DetectCycleDirectedImpl(5);
        g.addEdge(0,1);
        g.addEdge(2,1);
        g.addEdge(4,0);
        g.addEdge(4,2);
        g.addEdge(2,3);
        g.addEdge(3,4);
        g.printCycle();
    }
}
