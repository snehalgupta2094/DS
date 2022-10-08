package DP;

import java.util.Arrays;

public class LargetSquareMatrix {
static int ans=0;
//Recursion
 public static int solve(int matrix[][], int i, int j){
     if(i>=matrix.length || j>=matrix[0].length)
         return 0;
     int right=solve(matrix,i+1,j);
     int diagonal=solve(matrix,i+1,j+1);
     int down=solve(matrix,i,j+1);
     if(matrix[i][j]==1){
         int min=Math.min(right,Math.min(diagonal,down))+1;
         ans=Math.max(ans,min);
         return min;
     }
     else
     {
      return 0;
     }
 }
    //Recursion+Memoization
    public static int solve1(int matrix[][], int i, int j, int dp[][], int ans){
        if(i>=matrix.length || j>=matrix[0].length)
            return 0;

        if(dp[i][j]!=-1)
            return dp[i][j];

        int right=solve1(matrix,i+1,j,dp,ans);
        int diagonal=solve1(matrix,i+1,j+1,dp,ans);
        int down=solve1(matrix,i,j+1,dp,ans);
        if(matrix[i][j]==1){
            dp[i][j]=Math.min(right,Math.min(diagonal,down))+1;
             ans=Math.max(ans,dp[i][j]);
            return dp[i][j];
        }
        else
        {
            return dp[i][j]=0;
        }
    }
    //Tabulation
    public static int solve2(int matrix[][], int maximum){
     int row=matrix.length;
     int col=matrix[0].length;
     int dp[][]=new int[row+1][col+1];
     for(int i=row-1;i>=0;i--){
         for(int j=col-1;j>=0;j--){
             if(matrix[i][j]==1){
                 dp[i][j]=Math.min(dp[i+1][j],Math.min(dp[i+1][j+1],dp[i][j+1]))+1;
                 maximum = Math.max(maximum, dp[i][j]);

             }
             else
             {
                 dp[i][j]=0;
             }
         }
     }
        return dp[0][0];
    }
    //Space optimization
    public static int solve3(int matrix[][], int maximum){
        int row=matrix.length;
        int col=matrix[0].length;
        int curr[]=new int[row+1];
        int next[]=new int[row+1];
        for(int i=row-1;i>=0;i--){
            for(int j=col-1;j>=0;j--){
                if(matrix[i][j]==1){
                    curr[j]=Math.min(next[j],Math.min(next[j+1],curr[j+1]))+1;
                    maximum = Math.max(maximum, curr[j]);

                }
                else
                {
                    curr[j]=0;
                }
            }
            next=curr;
        }
        return next[0];
    }
    public static void main(String[] args) {
       int matrix[][]={{1,1,1,0},
                       {1,1,1,0},
                       {0,1,1,1},
                       {1,1,1,1}};
        System.out.println(solve(matrix,0,0));
        int dp[][]=new int[4][4];
        for(int i=0;i<4;i++){
            for(int j=0;j<4;j++)
                dp[i][j]=-1;
        }
        int max=0;
        max=solve1(matrix,0,0,dp,max);
        System.out.println(max);
        max=solve2(matrix,0);
        System.out.println(max);
        max=solve3(matrix,0);
        System.out.println(max);
    }
}
