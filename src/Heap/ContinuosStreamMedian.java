package Heap;

import java.util.Collection;
import java.util.Collections;
import java.util.PriorityQueue;

public class ContinuosStreamMedian {
    static PriorityQueue<Integer> maxHeap=new PriorityQueue<>(Collections.reverseOrder());
    static PriorityQueue<Integer> minHeap=new PriorityQueue<>();
    public static double getMedian(int element){
        double median=0.0;
        int result=Integer.compare(maxHeap.size(),minHeap.size());
        switch (result){
            case 0:
                //size of both heap is equal n,n
                if(element>median){
                    minHeap.offer(element);
                    median=minHeap.peek();
                }
                else
                {
                    maxHeap.offer(element);
                    median=maxHeap.peek();
                }
                break;
            case 1:
                //size of max heap is greater n,n-1
                if(element>median){
                    minHeap.offer(element);
                    median=(minHeap.peek()+maxHeap.peek())/2;
                }
                else{
                    minHeap.offer(maxHeap.poll());
                    maxHeap.offer(element);
                    median=(minHeap.peek()+maxHeap.peek())/2;
                }
                break;
            case -1:
                //size of min heap is greater n-1,n
                if (element>median){
                    maxHeap.offer(minHeap.poll());
                    minHeap.offer(element);
                    median=(minHeap.peek()+maxHeap.peek())/2;
                }
                else{
                    maxHeap.offer(element);
                    median=(minHeap.peek()+maxHeap.peek())/2;
                }
                break;
        }
        return median;
    }
    public static void main(String[] args) {
     int a[]={2,3,7,11,16};
     for(int i=0;i<a.length;i++){
         System.out.println(getMedian(a[i]));
     }
    }
}
