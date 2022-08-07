package Graphs.representation;

import java.util.ArrayList;

class Graph{
    ArrayList<ArrayList<Integer>> adj=new ArrayList<ArrayList<Integer>>();
    Graph(int v)
    {
        for(int i=0;i<v;i++)
        {
            adj.add(new ArrayList<>());
        }
    }
    public void addEdge(int u, int v)
    {
        adj.get(u).add(v);
        adj.get(v).add(u);
    }
    public void printGraph()
    {
        for(int i=0;i<adj.size();i++)
        {
            System.out.println("\n Adjacency list of vertex: "+i);
            for(int j=0;j<adj.get(i).size();j++)
            {
                System.out.print("->"+adj.get(i).get(j));
            }
        }
    }
}

public class List_Rep {

    public static void main(String[] args) {
       Graph graph=new Graph(5);
        graph.addEdge(0, 1);
        graph.addEdge(0, 4);
        graph.addEdge(1, 2);
        graph.addEdge(1, 3);
        graph.addEdge(1, 4);
        graph.addEdge( 2, 3);
        graph.addEdge( 3, 4);
        graph.printGraph();
    }
}
