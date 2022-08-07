package Graphs.stronglyConnected;

import java.util.ArrayList;
import java.util.Stack;

class TarjanSCCImpl{
    int v;
    static int time=0;
    ArrayList<ArrayList<Integer>> adj=new ArrayList<ArrayList<Integer>>();
    TarjanSCCImpl(int v){
        this.v=v;
        for(int i=0;i<v;i++)
            adj.add(new ArrayList<>());
    }
    public void addEdge(int u, int v)
    {
        adj.get(u).add(v);
    }
    public void findSCC_Tarjans(){
        int low[]=new int[v];
        int disc[]=new int[v];
        boolean presentInStack[]=new boolean[v];
        Stack<Integer> stack=new Stack<>();

        for(int i=0;i<v;i++){
            low[i]=-1;
            disc[i]=-1;
            if(disc[i]==-1)
                DFS_T(i,disc,low,presentInStack,stack);
        }
    }

    private void DFS_T(int u, int[] disc, int[] low, boolean[] presentInStack, Stack<Integer> stack) {
        disc[u]=low[u]=time;
        time++;
        stack.push(u);
        presentInStack[u]=true;
        for(int v: adj.get(u))
        {
            if(disc[v]==-1) //If v is not visited
            {
                DFS_T(v, disc, low,presentInStack,stack);
                low[u]=Math.min(low[u],low[v]);
            }
            else if(presentInStack[v]) // Back edge case
                low[u]=Math.min(low[u],disc[v]);
        }
        //u is head of SCC
        if(low[u]==disc[u])
        {
            while(stack.peek()!=u){
                System.out.println(stack.peek());
                presentInStack[stack.peek()]=false;
                stack.pop();
            }
            System.out.println(stack.peek());
            presentInStack[stack.peek()]=false;
            stack.pop();
        }
    }
}

public class TarjansSCC {

    public static void main(String[] args) {
      TarjanSCCImpl g=new TarjanSCCImpl(7);
      g.addEdge(0,1);
      g.addEdge(1,2);
      g.addEdge(1,3);
      g.addEdge(3,4);
      g.addEdge(4,0);
      g.addEdge(4,5);
      g.addEdge(4,6);
      g.addEdge(5,6);
      g.addEdge(6,5);

      g.findSCC_Tarjans();
    }
}
