package Graphs.cycleDetection;

import java.util.ArrayList;

class GraphColoringImpl{
    int v;
    static int WHITE=0,GRAY=1,BLACK=2;
    ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>();
    GraphColoringImpl(int v){
        this.v = v;
        for (int i = 0; i < v; i++)
            adj.add(new ArrayList<>());
    }
    public void addEdge(int u, int v) {
        adj.get(u).add(v);
    }
    public boolean detectCycle(){
        int color[]=new int[v];
        for(int i=0;i<v;i++)
            color[i]=WHITE;

        for(int i=0;i<v;i++){
            if(color[i]==WHITE)
                if(detectCycleUtil(i,color))
                    return true;
        }
        return false;
    }

    public boolean detectCycleUtil(int u, int color[]){
        color[u]=GRAY;
        for(int v: adj.get(u)){
            if(color[v]==GRAY)
                return true;
            if(color[v]==WHITE && detectCycleUtil(v,color))
                return true;
        }
        color[u]=BLACK;
        return false;
    }
}
public class DetectCycleByGraphColoring {

    public static void main(String[] args) {
        GraphColoringImpl g = new GraphColoringImpl(4);
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge( 1, 2);
        g.addEdge( 2, 0);
        g.addEdge( 2, 3);
        g.addEdge(3, 3);
        if (g.detectCycle())
            System.out.println("Graph contains cycle");
        else
            System.out.println("Graph doesn't contain cycle");
    }
}
