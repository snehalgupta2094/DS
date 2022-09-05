package Heap;

import java.util.PriorityQueue;

public class MinCostToConnectSticks {

    public static void main(String[] args) {
        //int a[]={2,3,4};
        int a[]={1,8,3,5};
        int minCost=0;
        //o/p: 14
        PriorityQueue<Integer> queue=new PriorityQueue<>();
        for(int i=0;i<a.length;i++){
            queue.offer(a[i]);
        }
        while (queue.size()>1){
            int i=queue.remove();
            int j=queue.remove();
            minCost=minCost+(i+j);
            queue.offer(i+j);
        }
        System.out.println(minCost);
    }

}
