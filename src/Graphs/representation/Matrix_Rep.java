package Graphs.representation;
class Graph_Mat{
    int[][] adj;
    Graph_Mat(int v){
        adj=new int[v][v];
    }
    public void addEdge(int u,int v)
    {
        adj[u][v]=1;
        adj[v][u]=1;
    }
    public void printGraph()
    {
        for(int i=0;i<adj.length;i++)
        {
            System.out.println("\n Adjacency list of vertex: "+i);
            for(int j=0;j<adj[i].length;j++)
            {
                if(adj[i][j]==1)
                    System.out.print("->"+j);
            }
        }
    }
}

public class Matrix_Rep {

    public static void main(String[] args) {
        Graph_Mat graph=new Graph_Mat(5);
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
