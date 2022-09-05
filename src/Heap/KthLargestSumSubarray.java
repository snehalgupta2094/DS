package Heap;

import java.util.PriorityQueue;

public class KthLargestSumSubarray {

    public int getKLargestSumSubarray(int a[], int k){
        PriorityQueue<Integer> mini=new PriorityQueue<>();
        for(int i=0;i<a.length;i++){
            int sum=0;
            for(int j=0;j<a.length;j++){
                sum+=a[j];
                if(mini.size()<k){
                    mini.offer(sum);
                }
                else
                {
                    if(sum>mini.peek()){
                        mini.remove();
                        mini.offer(sum);
                    }
                }
            }
        }
        return mini.remove();
    }
    public static void main(String[] args) {

    }
}
