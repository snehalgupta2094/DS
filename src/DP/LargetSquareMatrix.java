package DP;

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
        // ans=Math.max(ans,min);
         return min;
     }
     else
     {
      return 0;
     }
 }
    //Recursion+Memoization
    public static int solve1(int matrix[][], int i, int j, int dp[][]){
        if(i>=matrix.length || j>=matrix[0].length)
            return 0;

        if(dp[i][j]!=-1)
            return dp[i][j];

        int right=solve1(matrix,i+1,j,dp);
        int diagonal=solve1(matrix,i+1,j+1,dp);
        int down=solve1(matrix,i,j+1,dp);
        if(matrix[i][j]==1){
            dp[i][j]=Math.min(right,Math.min(diagonal,down))+1;
            // ans=Math.max(ans,min);
            return dp[i][j];
        }
        else
        {
            return dp[i][j]=0;
        }
    }
    //Tabulation
    public static int solve1(int matrix[][], int i, int j){
     return 0;
    }
    public static void main(String[] args) {
       int matrix[][]={{1,1,0,0},
                       {1,1,0,0},
                       {1,1,1,1},
                       {1,1,1,1}};
        System.out.println(solve(matrix,0,0));
    }
}
