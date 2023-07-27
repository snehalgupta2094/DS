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

//case1:target: odd
//odd turn: 21212..
//even turn: 21202..
//===================
//case2:target: even
//odd turn: 21202...
//even turn: 21212..
//===================
//1: 1,2,1
//2: 2
//2: 2

//  1->2,1,2,1,2==(5)
// -4->1,2,1,2,1,2,1,2,1 (9)
//  1->2,1,2,1,2== (5)
//  7->2== (3)
//  2->2,1,2,1,0,1== (6)
//==26

//  1->1,2,1,2,1,0,1 (7)
// -4->2,1,2,1,2,1,2,1,0,1 (10)
//  1->1,2,1,2,1,0,1 (7)
//  7->2 (1)
//  2->1,2,1,2,1 (5)

//6: 2,0,2
//6: 1,2,1


public class Solution_26Oct {
    public static int calculate(int a[], int target){
        int one=0;
        int two=0;
       for(int i=0;i<a.length;i++){
           one+=(target-a[i])%2;
           two+=Math.floor((target-a[i])/2);
       }
        System.out.println("1:"+one);
        System.out.println("2:"+two);
       int res=2*Math.min(one, two);
       if(one>two){
           res+=1+2*(one-two-1);
       }
       else if(two>one){
           two-=one;
           res+=4*Math.floor(two/3)+two%3+1;
       }
       return res;
    }
    public static void main(String[] args) {
        //  int a[]={6,10}; //4->{2,0}
        // int a[]={1,-4,1,2,7,9};
         int a[]={1,1,2,4};
         //  int a[]={10,8};
        int target=Integer.MIN_VALUE;
       for(int i=0;i<a.length;i++){
           if(a[i]>target)
               target=a[i];
       }
        System.out.println(Math.min(calculate(a,target),calculate(a,target+1)));
    }
}
