package Graphs.dsu;

class Pair{
    int first, second;
    Pair(int first, int second){
        this.first=first;
        this.second=second;
    }
}

class DSUImpl{
    int v;
    int parent[];

    DSUImpl(int v){
        this.v=v;
        this.parent=new int[v];
        for(int i=0;i<v;i++)
            parent[i]=-1;
    }

    public int find(int v){
        if(parent[v]==-1)
            return v;
        return find(parent[v]);
    }
    public void union(int fromP,int toP){
        fromP=find(fromP);
        toP=find(toP);
        parent[fromP]=toP;
    }
    boolean isCyclic(Pair[] pair){
        for(Pair edge:pair){
            //Find absolute parent of subset
            int fromP=find(edge.first);
            int toP=find(edge.second);
            if(fromP==toP){
                return true;
            }
            //Union of two sets
            union(fromP,toP);
        }
        return false;
    }
}
public class DSU {
    public static void main(String[] args) {
        DSUImpl g=new DSUImpl(4);
        Pair[] edges=new Pair[4];
        edges[0]=new Pair(0,1);
        edges[1]=new Pair(0,3);
        edges[2]=new Pair(2,3);
        edges[3]=new Pair(1,2);
        System.out.println(g.isCyclic(edges));
    }
}
