package Graphs.bfs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

class BFSImpl{
    int v;
    ArrayList<ArrayList<Integer>> adj=new ArrayList<ArrayList<Integer>>();
    BFSImpl(int v){
        this.v=v;
        //find neighbour for each vertex
        for(int i=0;i<v;i++)
            adj.add(new ArrayList<>());
    }
    public void addEdge(int u, int v)
    {
        adj.get(u).add(v);
        adj.get(v).add(u);
    }

    public void bfs(int v){
        boolean visited[]=new boolean[v];
        //there can be disconnected component so create for loop
        for(int i=0;i<v;i++){
            if(!visited[i])
                bfs(i,visited);
        }
    }

    public void bfs(int s, boolean visited[])
    {

        Queue<Integer> q=new LinkedList<>();
        visited[s]=true;
        q.add(s);

        while(!q.isEmpty())
        {
            //obtain front node
            s=q.poll();
            System.out.print(" "+s);

            //Traverse and find all neigbours
            for(int i=0;i<adj.get(s).size();i++)
            {
                int n=adj.get(s).get(i);
                if(!visited[n])
                {
                    visited[n]=true;
                    q.add(n);
                }
            }
        }
    }
}

public class BFS {

    public static void main(String[] args) {
        BFSImpl g=new BFSImpl(5);
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 0);
        g.addEdge(2, 3);
        g.addEdge(3, 3);
        g.addEdge(4,4);

        System.out.println("BFS");
        g.bfs(5);

    }
}
