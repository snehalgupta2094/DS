package Graphs.topologicalSort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

class TopologicalBFSImpl{
    int v;
    ArrayList<ArrayList<Integer>> adj=new ArrayList<ArrayList<Integer>>();
    int indegree[];
    TopologicalBFSImpl(int v){
        this.v=v;
        this.indegree=new int[v];
        for(int i=0;i<v;i++){
            adj.add(new ArrayList<>());
        }

    }
    public void addEdge(int u, int v)
    {
        adj.get(u).add(v);
    }
    public boolean kahns(int numCourses, int[][] prerequisites, int ans[]) {

      //create adjacency list
        for (int i = 0; i < prerequisites.length; i++)
            addEdge(prerequisites[i][1], prerequisites[i][0]);

      //find indegree
        int v=prerequisites.length;
        for(int i=0;i<v;i++){
            for(int neighbor: adj.get(i)){
                indegree[neighbor]++;
            }
        }

      //find vertex with 0 indegree push to queue
        Queue<Integer> queue=new LinkedList<>();
        for(int i=0;i<v;i++){
            if(indegree[i]==0)
                queue.add(i);
        }

        //bfs
        int count=0;
        while(!queue.isEmpty()){
            int front=queue.poll();
            ans[count++]=front;
            for(int neighbor: adj.get(front)){
                indegree[neighbor]--;
                if(indegree[neighbor]==0)
                    queue.add(neighbor);
            }
        }
        //if count not equal to vertex then there is cycle
       if(count!=v)
           return false;
       return true;
    }
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int ans[]=new int[v];
        if(kahns(numCourses, prerequisites, ans))
            return ans;
        return new int[0];
    }
}
public class TopologicalBFS {

    public static void main(String[] args) {
        int [][] prereq= {{1,0},{2,0},{3,1},{3,2}};
        TopologicalBFSImpl g=new TopologicalBFSImpl(4);
        int [] result=g.findOrder(4,prereq);
        System.out.println(Arrays.toString(result));

    }
}
