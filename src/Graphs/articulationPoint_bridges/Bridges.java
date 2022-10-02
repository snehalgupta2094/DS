package Graphs.articulationPoint_bridges;

import java.util.ArrayList;
import java.util.List;
//Tarjans
class BridgeImpl{
    BridgeImpl(int v){
        this.v=v;
        for(int i=0;i<v;i++)
            adj.add(new ArrayList<>());
    }
    int v;
    ArrayList<ArrayList<Integer>> adj=new ArrayList<>();
    public void bridges(){
        int disc[]=new int[v];
        int low[]=new int[v];
        boolean visited[]=new boolean[v];
        int parent=-1;
        int timer=0;
        for(int i=0;i<v;i++){
            disc[i]=-1;
            low[i]=-1;
        }

        //dfs
        for(int i=0;i<v;i++){
            if(!visited[i])
                dfs(i,parent,timer,disc,low,visited);
        }
    }
    public void addEdge(int u, int v)
    {
        adj.get(u).add(v);
        adj.get(v).add(u);
    }
    public List<List<Integer>> dfs(int node, int parent, int timer, int[] disc, int[] low, boolean[] visited) {
        ArrayList<List<Integer>> result=new ArrayList<>();
        visited[node]=true;
        disc[node]=low[node]=timer;
        timer++;
        for(int neighbor: adj.get(node)){
            if(neighbor==parent)
                continue;
            if(!visited[neighbor]){
                  dfs(neighbor,node,timer,disc,low,visited);
                  low[node]=Math.min(low[node],low[neighbor]);
                  //check edge is bridge
                  if(low[neighbor]>disc[node]){
                      System.out.println(node+"->"+neighbor);
                      ArrayList<Integer> ans=new ArrayList<>();
                      ans.add(node);
                      ans.add(neighbor);
                      result.add(ans);
                  }
            }
            else
            {
                //Back edge
                low[node]=Math.min(low[node],disc[neighbor]);
            }
        }
        return result;
    }
}
public class Bridges {

    public static void main(String[] args) {
        BridgeImpl g=new BridgeImpl(2);
/*        g.addEdge(0,1);
        g.addEdge(0,2);
        g.addEdge(1,2);
        g.addEdge(0,3);
        g.addEdge(3,4);*/
       /* g.addEdge(0,1);
        g.addEdge(1,2);
        g.addEdge(1,2);
        g.addEdge(2,0);
        g.addEdge(1,3);*/
        g.addEdge(0,1);
        g.addEdge(1,0);
        g.bridges();

    }

}
