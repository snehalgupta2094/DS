package DP;

import java.util.HashSet;
import java.util.Set;
/*
DP-based: Given a start point and endpoint on the number line (1, 2, 3...10) and a list of hurdles [1, 4],
with the ability to jump forward and backward two steps (e.g., from 2 to 4 or 2 to 1),
and considering the constraint of not being able to jump over hurdles, determine the count of starting points from which you can reach the destination.
Ensure that you cannot go beyond the specified start and end points on the number line.
* */
public class JumpWithHurdles {
    public static int findPossibleFromPoints(int index, int start,  int end, Set<Integer> hurdleSet, Set<Integer> visited){
        System.out.println("Start: " + index);
        if(index == end){
            return 1;
        }

        int forward=0, backward=0;
        if(index + 2 < end && !hurdleSet.contains(index+2) && !visited.contains(index+2)){
            visited.add(index+2);
           forward = findPossibleFromPoints(index + 2, start, end, hurdleSet, visited);
        }

        if(index - 2 >= start && !hurdleSet.contains(index-2) && !visited.contains(index-2)){
            backward = findPossibleFromPoints(index - 2, start, end, hurdleSet, visited);
        }
        
        return forward+backward+1;
    }

    public static void main(String[] args) {
        int[] hurdles = {2, 5};
        int end = 3;
        int start = 17;

        Set<Integer> hurdleSet = new HashSet<>();
        Set<Integer> visited = new HashSet<>();
        for(int hurdle : hurdles){
            hurdleSet.add(hurdle);
        }

        int jumpCounts = findPossibleFromPoints(1, start, end, hurdleSet, visited);
        System.out.println(visited);
        System.out.println(jumpCounts);
    }

}
