package Backtracking;

public class NQueens {

    public static boolean isSafe(int row, int col,int board[][], int n){

        int x=row,y=col;
        //check for same row
        while(y>=0){
            if(board[x][y]==1)
                return false;
            y--;
        }
       x=row;y=col;
        //check for diagonal
        while(y>=0 && x>=0){
            if(board[x][y]==1)
                return false;
            y--;
            x--;
        }
        x=row;y=col;
        //check for diagonal
        while(y>=0 && x<=n-1){
            if(board[x][y]==1)
                return false;
            y--;
            x++;
        }

        return true;
    }
    public static void solve(int col,int board[][], int n){

        //base case
        if(col==n){
            addSolution(board,n);
            return;
        }

        //solve 1 row and recursion will take care of rest
        for(int row=0;row<n;row++){
            if(isSafe(row,col,board,n)){
                //place 1 queen
                board[row][col]=1;
                solve(col+1,board,n);
                //backtrack
                board[row][col]=0;
            }
        }
    }

    private static void addSolution(int[][] board, int n) {
        for (int i = 0; i < n; i++) {
            System.out.println();
            for (int j = 0; j < n; j++) {
                System.out.print(board[i][j]+" ");
            }
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int board[][]=new int[4][4];
        solve(0,board,4);
    }
}
