package Interviews.karat;

import java.util.ArrayList;
import java.util.List;

/*
* Give a matrix of 1's and 0's. For example, matrix = [
["1","1","1","1","1"],
["1","1","0","0","1"],
["1","1","0","0","1"],
["1","1","1","1","1"]
]

Round 1: find the rectangle that is made of 0s, either return the start and end index OR height and length of the rectangle.
* There is only 1 rectangle in each matrix. I solved it by looping to find the first and last zero.

Round 2: same problem but now the matrix may contains many rectangles. Return the start and end indexes of each rec in an array.

matrix = [
["0","1","1","1","1"],
["1","1","0","0","1"],
["0","1","0","0","1"],
["0","1","1","1","1"],
["1","0","1","1","1"]
] => 4 rectangles in here . 0 by itself is also a rectangle, and vertical rectangle also counts.

I told them I would check for the surrounding 1 but I didnt have time to finish the second round. Any insight on how to solve ? Thank you!
* */
public class FindRectangles {

    public static void main(String[] args) {
        String[][] matrix = {
                {"1", "1", "1", "1", "1"},
                {"1", "1", "0", "0", "1"},
                {"1", "1", "0", "0", "1"},
                {"1", "1", "1", "1", "1"}
        };
        findAllRectangles(matrix);
       String matrix1[][] = {
                {"0", "1", "1", "1", "1"},
                {"1", "1", "0", "0", "1"},
                {"0", "1", "0", "0", "1"},
                {"0", "1", "1", "1", "1"},
                {"1", "0", "1", "1", "1"}
        };
        findAllRectangles(matrix1);
    }

    public static void findAllRectangles(String[][] matrix){
        List<Integer> startArray = new ArrayList<>();
        List<Integer> endArray = new ArrayList<>();
        boolean[][] visited = new boolean[matrix.length][matrix[0].length];

        for(int row = 0; row < matrix.length; row++){
            int[] start = new int[1];
            int[] end = new int[1];
            for(int col = 0; col < matrix[row].length; col++){
                if(!visited[row][col] && matrix[row][col].equals("0")){
                    startArray.add(row);
                    endArray.add(col);
                    findRectangle(row, col, matrix, start, end, visited);
                    startArray.add(start[0]);
                    endArray.add(end[0]);
                }
            }
        }
        System.out.println(startArray);
        System.out.println(endArray);
    }

    private static void findRectangle(int row, int col, String[][] matrix, int[] start, int[] end, boolean[][] visited) {
        if(row<0 || col<0 || row>= matrix.length || col>= matrix[0].length || visited[row][col] || matrix[row][col] == "1"){
            return;
        }

        visited[row][col] = true;
        findRectangle(row + 1, col, matrix, start, end, visited);
        findRectangle(row, col + 1, matrix, start, end, visited);
        findRectangle(row - 1, col, matrix, start, end, visited);
        findRectangle(row, col - 1, matrix, start, end, visited);

        if(matrix[row][col].equals("0") && start[0] <= row && end[0] <= col){
            start[0] = row;
            end[0] = col;
        }
    }


}
