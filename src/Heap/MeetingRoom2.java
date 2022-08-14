package Heap;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

//https://leetcode.com/problems/meeting-rooms-ii/
//https://www.lintcode.com/problem/919/description
public class MeetingRoom2 {

    public static void main(String[] args) {
        int intervals[][]={{7,10},{2,12},{15,20}};
        Arrays.sort(intervals, Comparator.comparing((int[] itv) -> itv[0]));
        System.out.println(Arrays.deepToString(intervals));
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        int count = 0;
        for (int[] itv : intervals){
            if (heap.isEmpty()) {
                count++;
            } else {
                if (itv[0] >= heap.peek()) {
                    heap.poll();
                } else {
                    count++;
                }
            }
            heap.offer(itv[1]);
        }

        System.out.println(count);
    }
}
