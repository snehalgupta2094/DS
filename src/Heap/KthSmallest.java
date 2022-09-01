package Heap;

import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

import Graphs.cycleDetection.IsBipartite;

public class KthSmallest {
    public static int solve(int arr[], int k){
        PriorityQueue<Integer> queue=new PriorityQueue<Integer>(Collections.reverseOrder());

        //Step1: Create max heap for first k elements
        for(int i=0;i<k;i++)
            queue.offer(arr[i]);

        //Step2:
        for(int i=k;i<arr.length;i++)
        {
            if(arr[i]<queue.peek()){
                queue.remove();
                queue.offer(arr[i]);
            }
        }
        System.out.println(Arrays.toString(queue.toArray()));
        return queue.remove();
    }
    public static void main(String[] args) {
        int arr[]={7,10,4,6,3,15};
        System.out.println(solve(arr,5));
    }
}
