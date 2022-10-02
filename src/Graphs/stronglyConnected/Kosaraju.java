package Graphs.stronglyConnected;

import java.util.ArrayList;
import java.util.Stack;

class KosarajuImpl {

    int v;
    ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>();
    ArrayList<ArrayList<Integer>> transpose = new ArrayList<ArrayList<Integer>>();

    KosarajuImpl(int v) {
        this.v = v;
        for (int i = 0; i < v; i++){
            adj.add(new ArrayList<>());
            transpose.add(new ArrayList<>());
        }
    }

    public void addEdge(int u, int v) {
        adj.get(u).add(v);
    }
    public void dfs(int node, boolean visited[],Stack<Integer> stack){
        visited[node]=true;
        for(int neighbor: adj.get(node)){
            if(!visited[neighbor]){
                dfs(neighbor,visited,stack);
            }
        }
        //topo logic
        stack.push(node);

    }
    public void findSCC(){

        //topo sort
     Stack<Integer> stack=new Stack<>();
     boolean visited[]=new boolean[v];

     for(int i=0;i<v;i++)
         if(!visited[i])
             dfs(i,visited,stack);

         //transpose
     for(int i=0;i<v;i++){
         visited[i]=false;
         for(int neighbor: adj.get(i))
         {
             transpose.get(neighbor).add(i);
         }
     }

    //dfs
        int count=0;
     while(!stack.isEmpty()){
         int top=stack.pop();
         if(!visited[top]){
             System.out.println("---SCC---");
             revDfs(top,visited);
             System.out.println();
             count++;
         }
     }
        System.out.println("count:"+count);
    }
    public void revDfs(int node,boolean[] visited){
        System.out.print(node+" ");
        visited[node]=true;
        for(int neighbor: transpose.get(node)){
            if(!visited[neighbor])
                revDfs(neighbor,visited);
        }
    }
}

public class Kosaraju {

    public static void main(String[] args) {
/*        KosarajuImpl g=new KosarajuImpl(6);
        g.addEdge(0,1);
        g.addEdge(1,2);
        g.addEdge(2,0);
        g.addEdge(2,3);
        g.addEdge(3,4);
        g.addEdge(4,5);
        g.addEdge(5,3);*/
        KosarajuImpl g=new KosarajuImpl(5);
        g.addEdge(0,1);
        g.addEdge(1,2);
        g.addEdge(2,0);
        g.addEdge(1,3);
        g.addEdge(3,4);
        g.findSCC();
    }
}
