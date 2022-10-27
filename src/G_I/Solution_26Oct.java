package G_I;

import java.util.Arrays;

/*
https://leetcode.com/discuss/interview-question/2736146/Make-Array-Values-Equal
Phone round
        Say we're given an array like [1,1,2,4], what's the minimum # of turns to make all values equal in this array?

        On each turn, you're allowed to do the following:

        If the turn is odd, you can increase a value by 1
        If the turn is even, you can increase a value by 2 (and only 2, cannot increase by 1)
        Or, you can do nothing and wait for the next turn
        For [1,2,2,4] the answer is:
        Day 1: Increase arr[0] to 2 -> [2,2,2,4]
        Day 2: Increase arr[2] to 4 -> [2,2,4,4]
        Day 3: Increase arr[1] to 3 -> [2,3,4,4]
        Day 4: Increase arr[0] to 4 -> [4,3,4,4]
        Day 5: Increase arr[1] to 4 -> [4,4,4,4]
        So we need 5 days.
        Approach1:
        */
public class Solution_26Oct {
static int count=0;
    public static int calculate(int a[], int index){
        if(index==a.length-1)
            return count;
        if(a[index]!=0)
            count=count+(a[index]%2)+(a[index]/2);
        return calculate(a,index+1);
    }
    public static void main(String[] args) {
        int a[]={1,-4,1,2,7,9};
      //  int a[]={10,8};
        int target=Integer.MIN_VALUE;
       for(int i=0;i<a.length;i++){
           if(a[i]>target)
               target=a[i];
       }
        System.out.println(target);
        for(int i=0;i<a.length;i++){
            a[i]=target-a[i];
        }
        System.out.println(calculate(a,0));
    }
}
