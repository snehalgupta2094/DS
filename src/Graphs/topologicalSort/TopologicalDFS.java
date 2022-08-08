package com.practice.Graphs.topologicalSort;

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

    public void dfs(int v, boolean visited[], Stack<Integer> stack){
        visited[v]=true;
        for(int i: adj.get(v)){
            if(!visited[i])
                dfs(i,visited,stack);
        }
        stack.push(v);
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
            if(visited[u]==0 && detectCycleUtil(v,visited))
                return true;
        }
        visited[u]=2;
        return false;
    }
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int ans[]=new int[numCourses];
        int j=0;
        boolean visited[]=new boolean[numCourses];
        Stack<Integer> stack=new Stack<Integer>();
        //create adjacency list
        for(int i=0;i<numCourses;i++)
            addEdge(prerequisites[i][1],prerequisites[i][0]);

        //Detect cycle with graph coloring
        if(detectCycle())
            return ans;

        //topologic sort with dfs and store result in stack
        for(int i=0;i<numCourses;i++) {
            if(!visited[i])
                dfs(i,visited,stack);
        }

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
