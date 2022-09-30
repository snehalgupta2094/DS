package Graphs.shortestPath;

import java.util.Arrays;

class DijkstraImpl{

    public int[] dijkstra(int graph[][], int src){
        int count=graph.length;
        int distance[]=new int[count];
        boolean visited[]=new boolean[count];

        for(int i=0;i<count;i++){
            distance[i]= Integer.MAX_VALUE;
        }
        distance[src]=0;
        for(int i=0;i<count;i++){

            //update distance between neighbor and
            int topNode=selectMinVertex(distance,visited);
            visited[topNode]=true;

            //update all neighbor vertex
            for(int neighbor=0;neighbor<count;neighbor++){
                if(graph[topNode][neighbor]!=0 && !visited[neighbor] && distance[topNode]!=Integer.MAX_VALUE &&(distance[topNode]+graph[topNode][neighbor]<distance[neighbor]))
                {
                    distance[neighbor]=distance[topNode]+graph[topNode][neighbor];
                }
            }
        }
       return distance;
    }
    public int selectMinVertex(int distance[], boolean visited[]){
        int min=Integer.MAX_VALUE;
        int vertex=-1;
        for(int i=0;i<distance.length;i++){
            if(!visited[i] && distance[i]<min){
                min=distance[i];
                vertex=i;
            }
        }
        return vertex;
    }
}
public class Dijkstra {
    public static void main(String[] args) {
        DijkstraImpl d=new DijkstraImpl();
        int graph[][] = new int[][] { { 0, 4, 0, 0, 0, 0, 0, 8, 0 },
                                      { 4, 0, 8, 0, 0, 0, 0, 11, 0 },
                                      { 0, 8, 0, 7, 0, 4, 0, 0, 2 },
                                      { 0, 0, 7, 0, 9, 14, 0, 0, 0 },
                                      { 0, 0, 0, 9, 0, 10, 0, 0, 0 },
                                      { 0, 0, 4, 14, 10, 0, 2, 0, 0 },
                                      { 0, 0, 0, 0, 0, 2, 0, 1, 6 },
                                      { 8, 11, 0, 0, 0, 0, 1, 0, 7 },
                                      { 0, 0, 2, 0, 0, 0, 6, 7, 0 } };
        int[] distance=d.dijkstra(graph,0);
        System.out.println(Arrays.toString(distance));
    }
}
