package Graphs.mst;
class PrimsImpl{
    int v;
    int [][] graph;

}
public class Prims {
    public static int selectMinVertex(int v,int value[], boolean setMST[]){
        int min=Integer.MAX_VALUE;
        int vertex=0;
        for(int i=0;i<v;i++){
            if(!setMST[i] && value[i]<min)
            {
                vertex=i;
                min=value[i];
            }
        }
        return vertex;
    }
    public static void findMST(int v,int graph[][]){
        int parent[]=new int[v]; //Stores MST
        boolean setMST[]=new boolean[v]; //checks if vertex is included in MST
        int value[]=new int[v]; //stores weight, used for edge relaxation

        parent[0]=-1;
        value[0]=0;

        for(int i=1;i<v;i++)
        {
            value[i]=Integer.MAX_VALUE;
        }
        for(int i=0;i<v-1;i++){
            //select best vertex by applying greedy method
            int u=selectMinVertex(v,value, setMST);
            setMST[u]=true; //include new vertex in MST
            for(int j=0;j<v;j++){
                /* 3 constraints
                 1. edge is present from u to j
                 2. vertex j is not included in mst
                 3. edge weight is less than current edge weight
                 */
                if(graph[u][j]!=0 && !setMST[j] && graph[u][j]<value[j])
                {
                    value[j]=graph[u][j];
                    parent[j]=u;
                }
            }
        }
        for(int i=1;i<v;i++)
        {
            System.out.println(parent[i]+"->"+i+" weight="+graph[parent[i]][i]);
        }
    }
    public static void main(String[] args) {
        int graph[][]={{0,4,6,0,0,0},{4,0,6,3,4,0},{6,6,0,1,8,9},{0,3,1,0,2,3},{0,4,8,2,0,7},{0,0,0,3,7,0}};
        findMST(6,graph);
    }
}
