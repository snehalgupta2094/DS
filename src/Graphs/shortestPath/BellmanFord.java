package Graphs.shortestPath;

import java.util.ArrayList;
import java.util.Arrays;
class BelmmanFordImpl{
    int v;
    int edges;
    ArrayList<int[]> adj=new ArrayList<>();
    BelmmanFordImpl(int v, int edges){
        this.v=v;
        this.edges=edges;

    }
    public void addEdge(int u, int v, int w){
        adj.add(new int[]{u,v,w});
    }
    public void bellmanFord(){
        int distance[]=new int[v];
        Arrays.fill(distance,Integer.MAX_VALUE);
        distance[0]=0;
        for(int i=0;i<adj.size();i++){
               int[] pair=adj.get(i);
               int u=pair[0];
                int v=pair[1];
                int wt=pair[2];

                if(distance[u]!=Integer.MAX_VALUE && distance[u]+wt<distance[v]){
                    distance[v]=Math.min(distance[v],distance[u]+wt);
                }

        }

        //check for negative weight cycle
        boolean flag=false;
        for(int i=0;i<edges;i++){
            int[] pair=adj.get(i);
            int u=pair[0];
            int v=pair[1];
            int wt=pair[2];
            if(distance[u]!=Integer.MAX_VALUE && distance[v]>distance[u]+wt){
                flag=true;
            }
        }
        System.out.println("Negative cycle?"+flag);
        System.out.println("Distance: "+Arrays.toString(distance));
    }

}
public class BellmanFord {

    public static void main(String[] args) {
        BelmmanFordImpl g=new BelmmanFordImpl(3,3);
        g.addEdge(0,1,5);
        g.addEdge(0,2,6);
        g.addEdge(2,1,-3);
        g.bellmanFord();
    }
}
