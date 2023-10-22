package Arrays;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;

//https://leetcode.com/discuss/interview-question/1975461/twilio-l3-oa-reject
public class MaxInMinSlidingWindow {
   static int max=Integer.MIN_VALUE;
    public static int findMax(int a[], int k){
        int[] output=new int[a.length-k+1];
        Deque<Integer> queue=new ArrayDeque<>();
        int j=0;
        for(int i=0;i<a.length;i++){
            if(!queue.isEmpty() && a[queue.getLast()]>=a[i]){
                queue.removeLast();
            }
            if(!queue.isEmpty() && i-queue.getFirst()>=k){
                queue.removeFirst();
            }
            queue.addLast(i);
            if(i>=k-1){   //current index>=window size-1
                output[j++]=a[queue.getFirst()];
                max=Math.max(max,a[queue.getFirst()]);
            }
        }
        System.out.println(Arrays.toString(output));
        return max;
    }


    //qfirst=1
    public static void main(String[] args) {
        int a[]={8,2,4,6, 11, 9, 7, 4, 2};
        int k=3;
        int max=findMax(a,k);
        System.out.println(max);
    }
}

//1,2,3,4,5,6,7,8
