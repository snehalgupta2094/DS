package Graphs.mst;

import java.util.ArrayList;
import java.util.HashMap;

class PrimsImpl{
    class Pair<K,V>{
        K first;
        V second;
        Pair(K first, V second){
            this.first=first;
            this.second=second;
        }
    }
    HashMap<Integer,ArrayList<Pair<Integer,Integer>>> adj=new HashMap<>();
    PrimsImpl(int v){
      this.v=v;
    }
    public void addEdge(int u, int v, int w){
        adj.putIfAbsent(u,new ArrayList<>());
        adj.get(u).add(new Pair<>(v,w));
    }
    int v;
    public void prims(int src){
        int[] key=new int[v];
        boolean[] mst=new boolean[v];
        int parent[]=new int[v];

       //Assign default
        for(int i=0;i<v;i++){
            key[i]=Integer.MAX_VALUE;
            parent[i]=-1;
        }
        key[src]=0;
        mst[src]=true;
        for(int i=0;i<v;i++){
            //find min value
            int vertex=selectMinVertex(mst,key);
            //mark true for min node
            mst[vertex]=true;
            //find all adjacent nodes
            for(Pair<Integer,Integer> neighbor: adj.get(vertex)){
                if(!mst[neighbor.first] && key[vertex]!=Integer.MAX_VALUE && neighbor.second<key[neighbor.first]){
                    key[neighbor.first]=neighbor.second;
                    parent[neighbor.first]=vertex;
                }
            }
        }
        //Process ans
        int sum=0;
        for(int i=0;i<v;i++){
            sum=sum+key[i];
        }
        System.out.println("MST: "+sum);
    }

    private int selectMinVertex(boolean[] mst, int[] key) {
        int min=Integer.MAX_VALUE;
        int vertex=0;
        for(int i=0;i<v;i++){
            if(!mst[i] && key[i]<min){
                min=key[i];
                vertex=i;
            }
        }
       return vertex;
    }

}

public class Prims {

    public static void main(String[] args) {
        PrimsImpl g=new PrimsImpl(5);
        g.addEdge(0,1,2);
        g.addEdge(0,3,6);
        g.addEdge(1,0,2);
        g.addEdge(1,3,8);
        g.addEdge(1,4,5);
        g.addEdge(1,2,3);
        g.addEdge(2,1,3);
        g.addEdge(2,4,7);
        g.addEdge(3,0,6);
        g.addEdge(3,1,8);
        g.addEdge(4,1,5);
        g.addEdge(4,2,7);
        g.prims(0);
    }
}
