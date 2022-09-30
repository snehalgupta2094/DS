package Graphs.shortestPath;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.PriorityQueue;

class DijkstraPQImpl{
    int v;
    HashMap<Integer, List<int[]>> adj=new HashMap<>(); //source, list of (neighbour,distance )
    DijkstraPQImpl(int v){
        this.v=v;
    }
    public void addEdge(int u, int v, int w){
        adj.putIfAbsent(u,new ArrayList<>());
        adj.get(u).add(new int[]{v,w});
    }
    public int[] dijkstraPQ(int src){

        PriorityQueue<int[]> pq=new PriorityQueue<>((a,b)->a[0]-b[0]); //a[0]->distance, a[1]->destination
        boolean []visited=new boolean[v];
        int[] distance=new int[v];
        for(int i=0;i<v;i++){
           distance[i]=Integer.MAX_VALUE;
        }
        distance[src]=0;
        pq.offer(new int[]{0,src});

        while(!pq.isEmpty()){
         int[] source=pq.poll();
         int dist=source[0];
         int topNode=source[1];

         if(visited[topNode])
             continue;

         visited[topNode]=true;
         for(int[] neighbor: adj.get(topNode)){
             if(!visited[neighbor[0]]){
                 if(distance[topNode]!=Integer.MAX_VALUE){
                     distance[neighbor[0]]=Math.min(dist+neighbor[1],distance[neighbor[0]]);
                     pq.offer(new int[]{distance[neighbor[0]],neighbor[0]});
                 }
             }
         }
        }
        return distance;
    }
}
public class DijkstraWithPrioirtyQueue {

    public static void main(String[] args) {
        DijkstraPQImpl g=new DijkstraPQImpl(5);
        g.addEdge(0,1,7);
        g.addEdge(0,2,1);
        g.addEdge(0,3,2);
        g.addEdge(1,0,7);
        g.addEdge(1,2,3);
        g.addEdge(1,3,5);
        g.addEdge(1,4,1);
        g.addEdge(2,0,1);
        g.addEdge(2,1,3);
        g.addEdge(3,0,2);
        g.addEdge(3,1,5);
        g.addEdge(3,4,7);
        g.addEdge(4,1,1);
        g.addEdge(4,3,7);
       int[] distance=g.dijkstraPQ(0);

       for(int i=0;i<5;i++){
           System.out.println("0->"+i+":"+distance[i]);
       }
    }
}
