package Graphs.shortestPath;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

class ShortestPath_Directed_Impl{
    ArrayList<ArrayList<Pair<Integer,Integer>>> adj=new ArrayList<>();
    int v;
    class Pair<K,V> {
        K val;
        V dist;
        Pair(K val, V dist){
            this.val=val;
            this.dist=dist;
        }
    }
    ShortestPath_Directed_Impl(int v){
        this.v=v;
        for(int i=0;i<v;i++)
            adj.add(new ArrayList<>());
    }
    public void addEdge(int u, int v , int dist){
        Pair<Integer,Integer> pair=new Pair<>(v,dist);
        adj.get(u).add(pair);
    }
    public void dfsUtil(int src, boolean[] visited, Stack<Integer> stack){
        visited[src]=true;
        for(Pair<Integer,Integer> neighbor: adj.get(src)){
            if(!visited[neighbor.val])
                dfsUtil(neighbor.val,visited,stack);
            stack.push(src);
        }
    }
    public void shortestDistance(int src){
        Stack<Integer> stack=new Stack<>();
        boolean visited[]=new boolean[v];
        for(int i=0;i<v;i++)
            if(!visited[0])
                dfsUtil(i, visited, stack);

        int distance[]=new int[v];
        for(int i=0;i<v;i++)
            distance[i]=Integer.MAX_VALUE;

        distance[src]=0;

        while (!stack.isEmpty()){
            int source=stack.pop();
            if(distance[source]!=Integer.MAX_VALUE)
                for(Pair<Integer,Integer> neighbor: adj.get(source)){
                   distance[neighbor.val]=Math.min(distance[source]+neighbor.dist,distance[neighbor.val]);
            }
        }
        System.out.println(Arrays.toString(distance));
    }

}
public class ShortestPath_Directed {

    public static void main(String[] args) {
        ShortestPath_Directed_Impl g=new ShortestPath_Directed_Impl(6);
        g.addEdge(0,1,5);
        g.addEdge(0,2,3);
        g.addEdge(1,2,2);
        g.addEdge(1,3,6);
        g.addEdge(2,3,7);
        g.addEdge(2,4,4);
        g.addEdge(2,5,2);
        g.addEdge(3,4,-1);
        g.addEdge(4,5,-2);
        g.addEdge(4,5,-2);
        g.shortestDistance(1);
    }
}
