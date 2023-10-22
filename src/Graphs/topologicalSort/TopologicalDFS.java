package Graphs.topologicalSort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

class TopologicalDFSImpl{
    int v;
    ArrayList<ArrayList<Integer>> adj=new ArrayList<ArrayList<Integer>>();
    TopologicalDFSImpl(int v){
        this.v=v;
        for(int i=0;i<v;i++)
            adj.add(new ArrayList<>());
    }
    public void addEdge(int u, int v)
    {
        adj.get(u).add(v);
    }


    public void dfs(int src, boolean visited[], Stack<Integer> stack){
        visited[src]=true;
        for(int neighbor: adj.get(src)){
            if(!visited[neighbor])
                dfs(neighbor,visited,stack);
        }
        stack.push(src);
    }

    public boolean detectCycle(){
        int visited[]=new int[v];
        for(int i=0;i<v;i++)
            if(visited[i]==0)
                if(detectCycleUtil(i, visited))
                    return true;

        return false;
    }

    public boolean detectCycleUtil(int u,int visited[]){
        visited[u]=1;
        for(int v:adj.get(u)){
            if(visited[v]==1)
                return true;
            if(visited[v]==0 && detectCycleUtil(v,visited))
                return true;
        }
        visited[u]=2;
        return false;
    }
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int ans[]=new int[numCourses];

        boolean visited[]=new boolean[numCourses];

        //create adjacency list
        for(int i=0;i<numCourses;i++)
            addEdge(prerequisites[i][1],prerequisites[i][0]);

        //Detect cycle with graph coloring
        if(detectCycle())
            return ans;

        Stack<Integer> stack=new Stack<Integer>();
        //topologic sort with dfs and store result in stack
        for(int i=0;i<numCourses;i++) {
            if(!visited[i])
                dfs(i,visited,stack);
        }
        int j=0;
        while(!stack.isEmpty())
            ans[j++]=stack.pop();
        return ans;
    }
}
public class TopologicalDFS {

    public static void main(String[] args) {
        int [][] prereq= {{1,0},{2,0},{3,1},{3,2}};
        TopologicalDFSImpl g=new TopologicalDFSImpl(4);
        int [] result=g.findOrder(4,prereq);
        System.out.println(Arrays.toString(result));

    }

}
