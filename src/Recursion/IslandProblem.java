package Recursion;

public class IslandProblem {
    static int count=0;
    public static void isIsland(int matrix[][], int i, int j){
        if(i<0 || i>=matrix.length || j<0 || j>=matrix[0].length)
            return;
        if(matrix[i][j]==1){
            matrix[i][j]=0;
            isIsland(matrix,i+1,j);
            isIsland(matrix,i,j+1);
            isIsland(matrix,i-1,j);
            isIsland(matrix,i,j-1);
            isIsland(matrix,i-1,j-1);
            isIsland(matrix,i+1,j+1);
            isIsland(matrix,i+1,j-1);
            isIsland(matrix,i-1,j+1);
        }
    }

    public static void main(String[] args) {
        int matrix[][]={{1,0,1,1},{1,0,0,0},{0,1,1,1}};
        for(int i=0;i<matrix.length;i++)
            for(int j=0;j<matrix[0].length;j++){
                if(matrix[i][j]==1){
                    isIsland(matrix,i,j);
                    count++;
                }
            }
        System.out.println(count);
    }
}
