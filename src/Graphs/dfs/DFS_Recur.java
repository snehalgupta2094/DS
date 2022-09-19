package Graphs.dfs;

import java.util.ArrayList;


class DFSImplRec{
    int v;
    ArrayList<ArrayList<Integer>> adj=new ArrayList<>();
    DFSImplRec(int v){
        this.v=v;
        for(int i=0;i<v;i++)
            adj.add(new ArrayList<>());
    }
    public void addEdge(int u, int v){
        adj.get(u).add(v);
        adj.get(v).add(u);
    }
    public void dfs(boolean visited[],ArrayList ans, int u){
        ans.add(u);
        visited[u]=true;
        //har connected node k liye recursive call
        for(int neighbor:adj.get(u)){
            if(!visited[neighbor])
                dfs(visited,ans,neighbor);
        }
    }
    ArrayList<ArrayList> ans=new ArrayList<>();
    public void dfs(){
        boolean visited[]=new boolean[v];
        //for all nodes call dfs if not visited
        for(int i=0;i<v;i++){
            if(!visited[i])
            {
                ArrayList component =new ArrayList<>();
                dfs(visited,component,i);
                ans.add(component);
            }
        }
        System.out.println(ans);
    }
}
public class DFS_Recur {
    public static void main(String[] args) {
        DFSImplRec g = new DFSImplRec(6);

        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 0);
        g.addEdge(1, 3);
        g.addEdge(2, 0);
        g.addEdge(2, 3);
        g.addEdge(3, 4);
        g.addEdge(3, 5);
        g.addEdge(4, 3);
        g.addEdge(5, 3);

        System.out.println("Following is the Depth First Traversal");
        g.dfs();

    }


}
