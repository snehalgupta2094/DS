package Graphs.stronglyConnected;

import java.util.ArrayList;
import java.util.Stack;

class KosarajuImpl {

    int v;
    ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>();
    ArrayList<ArrayList<Integer>> rev = new ArrayList<ArrayList<Integer>>();

    KosarajuImpl(int v) {
        this.v = v;
        for (int i = 0; i < v; i++){
            adj.add(new ArrayList<>());
            rev.add(new ArrayList<>());
        }
    }
    public void addEdge(int u, int v) {
        adj.get(u).add(v);
    }

    public void reverse(){
        for(int i=0;i<v;i++)
            for(int j: adj.get(i))
                rev.get(j).add(i);
    }
    public void DFS1(int u, boolean visited[], Stack<Integer> stack){
        visited[u]=true;
        for(int v: adj.get(u)) {
            if(!visited[v])
                DFS1(v,visited,stack);
        }
        stack.push(u);
    }
    public void DFS2(int u, boolean visited[]){
        System.out.print(u+" ");
        visited[u]=true;
        for(int v: rev.get(u)) {
            if(!visited[v])
                DFS2(v,visited);
        }
    }
    public void findSCC(){
     Stack<Integer> stack=new Stack<>();
     boolean visited[]=new boolean[v];

     for(int i=0;i<v;i++)
         if(!visited[i])
             DFS1(i,visited,stack);

     reverse();

     for(int i=0;i<v;i++)
         visited[i]=false;


     while(!stack.isEmpty()){
         int curr=stack.pop();
         if(!visited[curr]){
             System.out.println("SCC are:");
             DFS2(curr,visited);
             System.out.println();
         }
     }
    }
}
public class Kosaraju {

    public static void main(String[] args) {
        KosarajuImpl g=new KosarajuImpl(6);
        g.addEdge(0,1);
        g.addEdge(1,2);
        g.addEdge(2,0);
        g.addEdge(2,3);
        g.addEdge(3,4);
        g.addEdge(4,5);
        g.addEdge(5,3);
        g.findSCC();
    }
}
