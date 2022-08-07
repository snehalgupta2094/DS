package Graphs.dfs;

import java.util.ArrayList;
import java.util.Stack;


class DFSImpl{
    int v;
    ArrayList<ArrayList<Integer>> adj=new ArrayList<ArrayList<Integer>>();
    DFSImpl(int v){
        this.v=v;
        for(int i=0;i<v;i++)
            adj.add(new ArrayList<>());
    }
    public void addEdge(int u, int v){
        adj.get(u).add(v);
    }
    public void dfs(int s){
        boolean visited[]=new boolean[v];
        Stack<Integer> stack=new Stack<>();
        stack.push(s);
        while(!stack.isEmpty())
        {
            s=stack.pop();
            if(!visited[s])
            {
                System.out.print(s+" ");
                visited[s]=true;
            }
            for(int i=0;i<adj.get(s).size();i++)
            {
                int n=adj.get(s).get(i);
                if(!visited[n])
                    stack.push(n);
            }

        }
    }

}

public class DFS {
    public static void main(String[] args) {
        DFSImpl g = new DFSImpl(6);

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
        g.dfs(0);

    }
}
