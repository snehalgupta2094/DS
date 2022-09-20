package Graphs.cycleDetection;

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

    public boolean detectCycle_DFS(boolean[] visited,boolean dfsVisited[],int src){
        visited[src]=true;
        dfsVisited[src]=true;
        for(int neighbor: adj.get(src)){
            if(!visited[neighbor])
            {
                if(detectCycle_DFS(visited,dfsVisited,neighbor))
                    return true;
            }
            else if(dfsVisited[neighbor])
            {
                return true;
            }
        }
        dfsVisited[src]=false;
        return false;

    }
    public boolean detectCycle_DFS(){
        boolean visited[] =new boolean[v];
        boolean dfsVisited[]=new boolean[v];
        for(int i=0;i<v;i++){
            if(!visited[i]){
                if(detectCycle_DFS(visited,dfsVisited,i)){
                    return true;
                }
            }
        }
        return false;
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
}
public class DetectCycleDirected {
    public static void main(String[] args) {
      DetectCycleDirectedImpl g=new DetectCycleDirectedImpl(6);
        g.addEdge(0,1);
        g.addEdge(1,2);
        g.addEdge(3,0);
        g.addEdge(3,4);
        g.addEdge(4,5);
        System.out.println(g.detectCycle_DFS());
     /*   DetectCycleDirectedImpl g=new DetectCycleDirectedImpl(5);
        g.addEdge(0,1);
        g.addEdge(2,1);
        g.addEdge(4,0);
        g.addEdge(4,2);
        g.addEdge(2,3);
        g.addEdge(3,4);
        System.out.println(g.detectCycle_DFS());*/
    }
}
