package Graphs.shortestPath;
class DijkstraImpl{
    int v;
    public void dijkstra(int graph[][]){
        int value[]=new int[v];
        boolean processed[]=new boolean[v];
        int parent[]=new int[v];
        for(int i=0;i<v;i++){
            parent[i]=-1;
            value[i]= Integer.MAX_VALUE;
        }
        parent[0]=-1;
        value[0]=0;
        for(int i=0;i<v-1;i++){
            int u=selectMinVertex(value,processed);
            processed[u]=true;
            for(int j:graph[i]){
                if(graph[u][j]!=0 && !processed[j] && value[u]!=Integer.MAX_VALUE &&(value[u]+graph[u][j]<value[j]))
                {
                    value[j]=value[u]+graph[u][j];
                    parent[j]=u;
                }
            }
        }
    }
    public int selectMinVertex(int value[], boolean processed[]){
        int min=Integer.MAX_VALUE;
        int vertex=0;
        for(int i=0;i<v;i++){
            if(!processed[i] && value[i]<min){
                min=value[i];
                vertex=i;
            }
        }
        return vertex;
    }
}
public class Dijkstra {
    public static void main(String[] args) {

    }
}
