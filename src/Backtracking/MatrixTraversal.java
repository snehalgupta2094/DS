package Backtracking;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class MatrixTraversal {
    public static void findAllPaths(int a[][], List<Integer> ans, int m, int n, int x, int y, int visited[][]){
        //base condition
        if(x==m-1 && y==n-1){
            ans.add(a[x][y]);
            System.out.println(ans);
            ans.remove(ans.size()-1);
            return;
        }
        ans.add(a[x][y]);
        visited[x][y]=1;
        if(isSafe(m,n,x+1,y,visited)){
            findAllPaths(a,ans,m,n,x+1,y,visited);
        }
        if(isSafe(m,n,x,y+1,visited)){
            findAllPaths(a,ans,m,n,x,y+1,visited);
        }
        visited[x][y]=0;
        ans.remove(ans.size()-1);
    }

    private static boolean isSafe(int m, int n, int x, int y, int visited[][]) {
        return (x>=0 && x<m) && (y>=0 && y<n) && visited[x][y]==0;
    }

    public static void main(String[] args) {
        int a[][]={{1,2,3,4},
                   {5,6,7,8},
                   {9,10,11,12}};
        int visited[][]=new int[a.length][a[0].length];
        findAllPaths(a,new ArrayList<>(),a.length,a[0].length,0,0,visited);
    }

}
