package Graphs.dsu;
class Pair1{
    int first, second;
    Pair1(int first, int second){
        this.first=first;
        this.second=second;
    }
}
class Node{
    int parent, rank;
}
class DSUByRankImpl{
    int v;
    Node node[];

    DSUByRankImpl(int v){
        this.v=v;
        this.node=new Node[v];
        for(int i=0;i<v;i++)
        {
            node[i]=new Node();
            node[i].parent=-1;
            node[i].rank=0;
        }
    }
    public int find(int v){
        if(node[v].parent==-1)
            return v;
        return node[v].parent=find(node[v].parent); //Path Compression
    }
    public void union(int fromP, int toP){
        //union by rank
        if(node[fromP].rank<node[toP].rank) //fromp has higher rank
            node[fromP].parent=toP;
        else if(node[fromP].rank>node[toP].rank) //
            node[toP].parent=fromP;
        else{
            //both have same rank so anyone can be made parent
            node[fromP].parent=toP;
            node[toP].rank+=1; //increase rank of parent
        }
    }

    public boolean isCycle(Pair1 pairs[]){
        for(Pair1 p: pairs){
            int fromP=find(p.first); //find absolute parent of subset
            int toP=find(p.second);

            if(fromP==toP){
                return true;
            }
            union(fromP,toP);
        }
        return true;
    }
}
public class DSUByRank {

    public static void main(String[] args) {
        DSUByRankImpl g=new DSUByRankImpl(4);
        Pair1[] edges=new Pair1[4];
        edges[0]=new Pair1(0,1);
        edges[1]=new Pair1(0,3);
        edges[2]=new Pair1(2,3);
        edges[3]=new Pair1(1,2);
        System.out.println(g.isCycle(edges));
    }
}
