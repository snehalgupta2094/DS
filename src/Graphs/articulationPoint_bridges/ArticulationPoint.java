package Graphs.articulationPoint_bridges;

import java.util.ArrayList;
class ArticulationPointImpl{
    //Tarjans
    ArrayList<ArrayList<Integer>> adj=new ArrayList<>();
    int v;
    ArticulationPointImpl(int v){
        this.v=v;
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
    public void articulationPoint(){
        int disc[]=new int[v];
        int low[]=new int[v];
        boolean visited[]=new boolean[v];
        boolean ap[]=new boolean[v];
        int parent=-1;

        for(int i=0;i<v;i++){
            if(!visited[i])
                dfs(i,parent,low,disc,visited,ap);
        }
      for(int i=0;i<v;i++)
          if (ap[i]) {
              System.out.println(i);
          }
    }
    int timer=0;
    private void dfs(int node, int parent, int[] low, int[] disc, boolean[] visited,boolean[] ap) {
        low[node]=disc[node]=timer++;
        visited[node]=true;
        int child=0;
        for(int neighbor: adj.get(node)) {
            if(neighbor==parent)
                continue;
            if (!visited[neighbor]) {
                child++;
                dfs(neighbor,parent,low,disc,visited,ap);
                low[node]=Math.min(low[node],low[neighbor]);
                if(low[neighbor]>=disc[node] && parent!=-1)
                {
                    ap[node]=true;
                }
            } else{
                //back edge
                low[node]=Math.min(low[node],disc[neighbor]);
            }
            if(parent==-1 && child>1){
                ap[node]=true;
            }

        }
    }
}
public class ArticulationPoint {

    public static void main(String[] args) {
        ArticulationPointImpl g=new ArticulationPointImpl(4);
        g.addEdge(0,1);
        g.addEdge(1,2);
        g.addEdge(1,2);
        g.addEdge(2,0);
        g.addEdge(1,3);
        g.articulationPoint();
    }

}
