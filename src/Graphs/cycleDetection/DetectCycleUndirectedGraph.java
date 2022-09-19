package Graphs.cycleDetection;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

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
    boolean detectCycle_BFS(int src, boolean visited[]){
        int parent[]=new int[v];
        parent[src]=-1;
        visited[src]=true;
        Queue<Integer> q=new LinkedList<>();
        q.add(src);

        while (!q.isEmpty()){
            int front=q.poll();
            for(int neighbour: adj.get(front)){
                if(visited[neighbour] && neighbour!=parent[front])
                    return true;
                else if(!visited[neighbour]){
                    visited[neighbour]=true;
                    parent[neighbour]=front;
                    q.add(neighbour);
                }
            }
        }
        return false;
    }
    boolean detectCycle_BFS(){
        boolean visited[]=new boolean[v];

        for(int i=0;i<v;i++){
            if(!visited[i])
            {
                if(detectCycle_BFS(i,visited))
                    return true;
            }
        }
        return false;
    }


    boolean detectCycle_DFS(){
        boolean visited[]=new boolean[v];
        for(int i=0;i<v;i++){
            if(!visited[i])
                if(detectCycle_DFS(i,visited,-1))
                    return true;
        }
        return false;
    }
    boolean detectCycle_DFS(int u,boolean visited[],int parent){
        visited[u]=true;
        for(int v:adj.get(u)){
            if(!visited[v]){
                if(detectCycle_DFS(v,visited,u))
                    return true;
            }else if(v!=parent)
                return true;
        }
        return false;
    }
}
public class DetectCycleUndirectedGraph {
    public static void main(String[] args) {
     /*  DetectCycleUndirectedGraphImpl g=new DetectCycleUndirectedGraphImpl(4);
        g.addEdge(0,1);
        g.addEdge(1,2);
        g.addEdge(2,3);*/
     //   System.out.println(g.detectCycle());
        DetectCycleUndirectedGraphImpl g=new DetectCycleUndirectedGraphImpl(4);
        g.addEdge(0,1);
        g.addEdge(1,2);
        g.addEdge(0,2);
        g.addEdge(2,3);
        System.out.println(g.detectCycle_BFS());
    }
}
