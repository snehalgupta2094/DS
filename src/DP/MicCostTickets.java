package DP;

import java.util.Arrays;

public class MicCostTickets {
    //Recursion
    public static int solve1(int[]days, int costs[], int index, int n){
        //base case
        if(index>=n){
            return 0;
        }
        //For 1 day
        int option1=solve1(days,costs,index+1,n)+costs[0];

        //For 7 day
        int i;
        for(i=index;i<n && days[i]<days[index]+7;i++);
        int option2=solve1(days,costs,i,n)+costs[1];

        //For 30 day
        for(i=index;i<n && days[i]<days[index]+30;i++);
        int option3=solve1(days,costs,i,n)+costs[2];

        return Math.min(option1,Math.min(option2,option3));
    }
    //Recursion+Memoization
    public static int solve2(int[]days, int costs[], int index, int n, int dp[]){
        //base case
        if(index>=n){
            return 0;
        }
        if(dp[index]!=-1)
            return dp[index];
        //For 1 day
        int option1=solve2(days,costs,index+1,n,dp)+costs[0];

        //For 7 day
        int i;
        for(i=index;i<n && days[i]<days[index]+7;i++);
        int option2=solve2(days,costs,i,n,dp)+costs[1];

        //For 30 day
        for(i=index;i<n && days[i]<days[index]+30;i++);
        int option3=solve2(days,costs,i,n,dp)+costs[2];

        dp[index]= Math.min(option1,Math.min(option2,option3));
        return dp[index];
    }

    public static void main(String[] args) {
         int days[]={1,4,6,7,8,20};
         int costs[]={2,7,15};
         int n=days.length;
        System.out.println(solve1(days,costs,0,n));
        int dp[]=new int[n];
        Arrays.fill(dp, -1);
        System.out.println(solve2(days,costs,0,n,dp));
    }
}
