package Graphs.mst;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

class KruskalImpl{
    ArrayList<Edge> adj=new ArrayList<>();
    int v;
    KruskalImpl(int v){
        this.v=v;
    }
        public void addEdge(int u, int v, int w){
        adj.add(new Edge(u,v,w));
        }

    class Edge{
        int src;
        int dest;
        int wt;
        Edge(int src, int dest, int wt){
            this.src=src;
            this.dest=dest;
            this.wt=wt;
        }
    }
    public void unionSet(int u, int v,int rank[],int parent[]){
     //   u=findParent(parent,u);
      //  v=findParent(parent,v);
        if(rank[u]<rank[v])
            parent[u]=v;
        else if(rank[u]>rank[v])
            parent[v]=u;
        else
        {
            parent[v]=u;
            rank[u]++;
        }
    }
    public int findParent(int parent[], int node){
          if(parent[node]==node)
              return node;
          return findParent(parent,parent[node]);
    }
    public void makeSet(int parent[], int rank[], int v){
        for(int i=0;i<v;i++){
            parent[i]=i;
            rank[i]=0;
        }
    }
    public void kruskal(){
        Collections.sort(adj, new Comparator<Edge>() {
            @Override
            public int compare(Edge o1, Edge o2) {
                return Integer.compare(o1.wt, o2.wt);}
        });
        int parent[]=new int[v];
        int rank[]=new int[v];
        makeSet(parent,rank,v);
        int minWeight=0;
        for(Edge edge: adj){
           int u=findParent(parent,edge.src);
           int v=findParent(parent,edge.dest);
           int wt=edge.wt;
           if(u!=v){
               minWeight+=wt;
           unionSet(u,v,rank,parent);
           }
        }
        System.out.println(minWeight);
    }
}
public class Kruskal {

    public static void main(String[] args) {
        KruskalImpl g=new KruskalImpl(9);
        g.addEdge(1,2,2);
        g.addEdge(1,4,1);
        g.addEdge(1,5,4);
        g.addEdge(4,5,9);
        g.addEdge(4,3,5);
        g.addEdge(2,4,3);
        g.addEdge(2,3,3);
        g.addEdge(2,6,7);
        g.addEdge(3,3,6);
        g.kruskal();
    }

}
