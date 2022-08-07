package Graphs.bfs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

class BFSImpl{
    int v;
    ArrayList<ArrayList<Integer>> adj=new ArrayList<ArrayList<Integer>>();
    BFSImpl(int v){
        this.v=v;
        for(int i=0;i<v;i++)
            adj.add(new ArrayList<>());
    }
    public void addEdge(int u, int v)
    {
        adj.get(u).add(v);
    }
    public void bfs(int s)
    {
        boolean visited[]=new boolean[v];
        Queue<Integer> q=new LinkedList<>();
        visited[s]=true;
        q.add(s);

        while(!q.isEmpty())
        {
            s=q.poll();
            System.out.print(" "+s);

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
        BFSImpl g=new BFSImpl(4);
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 0);
        g.addEdge(2, 3);
        g.addEdge(3, 3);

        System.out.println("BFS");
        g.bfs(2);

    }
}
