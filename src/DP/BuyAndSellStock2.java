package DP;

import java.util.Arrays;

//buy-0 (not allowed)
//buy-1 (allowed)
//buy0- sell karo, ignore/skip
//buy1- buy karo, ignore/skip
public class BuyAndSellStock2 {
//Recursion
    public static int solve(int prices[],int i, int buy){
        if(i==prices.length)
            return 0;
        int profit=0;
        if(buy==1){
          int buyKaro=-prices[i]+ solve(prices,i+1,0);
          int skipKaro=0+solve(prices,i+1,1);
          profit=Math.max(buyKaro,skipKaro);
        }
        else
        {
            int sellKaro=prices[i]+ solve(prices,i+1,1);
            int skipKaro=0+solve(prices,i+1,0);
           profit=Math.max(sellKaro,skipKaro);
        }
        return profit;
    }
    //Recursion+memoization
    public static int solve1(int prices[],int i, int buy, int dp[][]){
        if(i==prices.length)
            return 0;
        if(dp[i][buy]!=-1)
            return dp[i][buy];
        int profit=0;
        if(buy==1){
            int buyKaro=-prices[i]+ solve1(prices,i+1,0,dp);
            int skipKaro=0+solve1(prices,i+1,1,dp);
            profit=Math.max(buyKaro,skipKaro);
        }
        else
        {
            int sellKaro=prices[i]+ solve1(prices,i+1,1,dp);
            int skipKaro=0+solve1(prices,i+1,0,dp);
            profit=Math.max(sellKaro,skipKaro);
        }
       return dp[i][buy]=profit;
    }
    public static void main(String[] args) {
        int[] prices={7,1,5,3,6,4};
        System.out.println(solve(prices,0,1));
        int dp[][]=new int[prices.length][2];
        for(int i=0;i<prices.length;i++)
        {
            dp[i][0]=-1;
            dp[i][1]=-1;
        }
        System.out.println(solve1(prices,0,1,dp));
    }
}
