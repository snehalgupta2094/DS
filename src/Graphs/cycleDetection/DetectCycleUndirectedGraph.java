package com.practice.Graphs.cycleDetection;

import java.util.ArrayList;

class DetectCycleUndirectedGraphImpl{
    ArrayList<ArrayList<Integer>> adj=new ArrayList<ArrayList<Integer>>();
    int v;
    DetectCycleUndirectedGraphImpl(int v){
        this.v=v;
        for(int i=0;i<v;i++)
            adj.add(new ArrayList<>());
    }
    public void addEdge(int u, int v) {
        adj.get(u).add(v);
        adj.get(v).add(u);
    }
    boolean detectCycle(){
        boolean visited[]=new boolean[v];
        for(int i=0;i<v;i++){
            if(!visited[i])
                if(detectCycleUtil(i,visited,-1))
                    return true;
        }
        return false;
    }
    boolean detectCycleUtil(int u,boolean visited[],int parent){
        visited[u]=true;
        for(int v:adj.get(u)){
            if(!visited[v]){
                if(detectCycleUtil(v,visited,u))
                    return true;
            }else if(v!=parent)
                return true;
        }
        return false;
    }
}
public class DetectCycleUndirectedGraph {
    public static void main(String[] args) {
       /* DetectCycleUndirectedGraphImpl g=new DetectCycleUndirectedGraphImpl(4);
        g.addEdge(0,1);
        g.addEdge(1,2);
        g.addEdge(2,3);
        System.out.println(g.detectCycle());*/
        DetectCycleUndirectedGraphImpl g=new DetectCycleUndirectedGraphImpl(4);
        g.addEdge(0,1);
        g.addEdge(1,2);
        g.addEdge(0,2);
        g.addEdge(2,3);
        System.out.println(g.detectCycle());
    }
}
