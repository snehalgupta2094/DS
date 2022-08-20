package Backtracking;

import java.util.ArrayList;

public class RatInAMaze {
    public static void solve(int arr[][], int x, int y, int n, int visited[][], ArrayList<String> ans, String path){

        //base case
        if(x==n-1 && y==n-1){
            ans.add(path);
            return;
        }
        visited[x][y]=1;
        //D L R U
        if(isSafe(x+1,y,visited,arr,n)){
            solve(arr,x+1,y,n,visited,ans,path+"D");
        }
        if(isSafe(x,y-1,visited,arr,n)){
            solve(arr,x,y-1,n,visited,ans,path+"L");
        }
        if(isSafe(x,y+1,visited,arr,n)){
            solve(arr,x,y+1,n,visited,ans,path+"R");
        }
        if(isSafe(x-1,y,visited,arr,n)){
            solve(arr,x-1,y,n,visited,ans,path+"U");
        }
        visited[x][y]=0;

    }

    private static boolean isSafe(int x, int y, int[][] visited, int[][] arr, int n) {
        return  ((x>=0 && x<n) && (y>=0 && y<n)) && visited[x][y]==0 && arr[x][y]==1;
    }

    public static void main(String[] args) {
        int arr[][]={{1,0,0,0},{1,1,0,0},{1,1,0,0},{0,1,1,1}};
        int visited[][]=new int[4][4];
        ArrayList<String> ans=new ArrayList<>();
        String path="";
        solve(arr,0,0,4,visited,ans,path);
        System.out.println(ans);
    }
}
