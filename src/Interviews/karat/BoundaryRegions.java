package Interviews.karat;
/*
* This was the question asked at my recent Phone Interview with Google.
Given a 2-D matrix that contains binary digits of 1's and 0's. Return the boundary coordinates of each region covered by 1's.

Example:

Input:

0 0 0 0 0 0
0 1 1 0 1 1
1 1 1 1 0 1
0 1 1 0 1 1
0 0 0 0 1 0

Output:

Here we have two region boundaries and they are marked with numbers 2 and 3.
(For representation alone. The result should just be the boundary coordinates)

0 0 0 0 0 0
0 2 2 0 3 3
2 1 1 2 0 3
0 2 2 0 3 3
0 0 0 0 3 0

The expected output in this case is:
Two regions boundary points.
Region 1-
[[1,1],[1,2],[2,0],[3,1],[3,2],[2,3],
Region 2-
[1,4],[1,5],[2,5],[3,4],[3,5],[4,4]]

The result should be a List containing the boundary coordinates marked with the numbers 2 and 3.

P.S: The region does not check for diagonal 1's. (It only considers top,bottom,right and left to mark the regions)
* */
public class BoundaryRegions {

}
