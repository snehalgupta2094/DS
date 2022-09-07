package Heap;

import java.util.Collections;
import java.util.PriorityQueue;

public class MedianInStreamLeetCode {
    static PriorityQueue<Integer> maxHeap=new PriorityQueue<>(Collections.reverseOrder());
    static PriorityQueue<Integer> minHeap=new PriorityQueue<>();
    public static void addAddNum(int num){
        //if incoming number is larger then min then add to min heap else add to max heap
        if(minHeap.size()>0 && num>=minHeap.peek()){
            minHeap.offer(num);
        }
        else{
            maxHeap.offer(num);
        }
        //Check size, if diff is 2 then rebalance heaps
        if(maxHeap.size()-minHeap.size()==2){
            minHeap.offer(maxHeap.poll());
        }
        else if(minHeap.size()-maxHeap.size()==2){
            maxHeap.offer(minHeap.poll());
        }
    }

    public static double findMedian(){
        double median=0.0;
        if(maxHeap.size()==minHeap.size())
        {
            median=(maxHeap.peek()+minHeap.peek())/2;
        }
        else if(maxHeap.size()>minHeap.size()){
            median=maxHeap.peek();
        }
        else
        {
            median=minHeap.peek();
        }
        return median;
    }

    public static void main(String[] args) {
        addAddNum(2);
        addAddNum(3);
        addAddNum(7);
        addAddNum(11);
        addAddNum(16);
        addAddNum(19);
        System.out.println(findMedian());
    }
}
