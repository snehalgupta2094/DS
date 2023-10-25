package Matrix;

public class MinMoves {

/*In a grid of size (m-1) by (n-1), where each cell is marked with either 0 (representing a clear path) or 1 (indicating an obstacle),
a user starts at the top-left corner (cell 0,0).
They can take either of below in 1 move:
i+k,j
i-k,j
i,j+k
i,j-k
 The goal is to reach the bottom-right corner (cell m-1, n-1) while taking the fewest possible moves.
If there is no path to reach the bottom-right corner, the function should return -1
* */
    public static int move(int arr[][], int i, int j, int k, int m, int n, int visited[][]){
     if (i==m-1 && j==n-1)
         return 0;

        if(i<0 || j<0 || i>=m || j>=n || arr[i][j]==1 || k<=0 || visited[i][j]==1){
            return -1;
        }

        visited[i][j]=1;

         int left=move(arr,i+k,j,k,m,n,visited);
         int right=move(arr,i-k,j,k,m,n,visited);
         int top=move(arr,i,j-k,k,m,n,visited);
         int bottom=move(arr,i,j+k,k,m,n,visited);
        visited[i][j]=0;
        int minMoves=Integer.MAX_VALUE;
       if(left!=-1){
           minMoves=Math.min(minMoves,left+1);
       }
        if(right!=-1){
            minMoves=Math.min(minMoves,right+1);
        }
        if(top!=-1){
            minMoves=Math.min(minMoves,top+1);
        }
        if(bottom!=-1){
            minMoves=Math.min(minMoves,bottom+1);
        }
        if(minMoves==Integer.MAX_VALUE)
            return -1;
    return minMoves;
    }
    public static int findMinimumMoves(int arr[][], int k){

        int visited[][]=new int[arr.length][arr[0].length];
        return move(arr,0,0,k,arr.length,arr[0].length,visited);
    }
    public static void main(String[] args) {
        int k=1;
        int arr[][]={{0,1,1,0},
                     {0,0,1,0},
                     {0,0,0,0}};
        //o/p=5
        System.out.println(findMinimumMoves(arr,k));

    }
}
