package Graphs.shortestPath;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

class ShortestPath_Undirected_Imp{
    ArrayList<ArrayList<Integer>> adj=new ArrayList<>();
    int v;
    ShortestPath_Undirected_Imp(int v){
        this.v=v;
        for(int i=0;i<v;i++)
            adj.add(new ArrayList());
    }
    public void addEdge(int u, int v){
        adj.get(u).add(v);
    }
    public int[] bfs(int src){
    boolean visited[]=new boolean[v];
    int parent[]=new int[v];
    Queue<Integer> queue=new LinkedList<>();
    queue.add(src);
    parent[src]=-1;
    visited[src]=true;

   while (!queue.isEmpty())
   {
       int front=queue.poll();
       for(int neighbor: adj.get(front)){
           if(!visited[neighbor]){
               parent[neighbor]=front;
               visited[neighbor]=true;
               queue.add(neighbor);
           }
       }
   }
        System.out.println(Arrays.toString(parent));
   return parent;
    }
}
public class ShortestPath_Undirected {

    public static void main(String[] args) {
        ShortestPath_Undirected_Imp g=new ShortestPath_Undirected_Imp(8);
        g.addEdge(0,1);
        g.addEdge(0,2);
        g.addEdge(0,3);
        g.addEdge(1,0);
        g.addEdge(1,4);
        g.addEdge(2,0);
        g.addEdge(2,7);
        g.addEdge(3,0);
        g.addEdge(3,5);
        g.addEdge(4,1);
        g.addEdge(4,7);
        g.addEdge(5,3);
        g.addEdge(5,6);
        g.addEdge(6,5);
        g.addEdge(6,7);
        g.addEdge(7,4);
        g.addEdge(7,6);

        int[] parent=g.bfs(0);

        //print all distances
        for(int i=0;i<8;i++){
            System.out.println(parent[i]+"->"+i);
        }
    }
}
