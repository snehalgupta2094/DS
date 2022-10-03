package DP;

import java.util.Arrays;

public class CoinChange {

    //Recursion
    public static int solve1(int coins[], int target){
        //base condition
        if(target==0)
            return 0;

        if(target<0)
            return Integer.MAX_VALUE;

        int mini=Integer.MAX_VALUE;
        for(int i=0;i<coins.length;i++){
          int ans=solve1(coins,target-coins[i]);

          if(ans!=Integer.MAX_VALUE)
              mini=Math.min(mini,ans+1);
        }
        return mini;
    }
    //Recursion+Memoization
    public static int solve2(int coins[], int target, int dp[]){
        //base condition
        if(target==0)
            return 0;

        if(target<0)
            return Integer.MAX_VALUE;

        if(dp[target]!=-1)
            return dp[target];

        int mini=Integer.MAX_VALUE;
        for(int i=0;i<coins.length;i++){
            int ans=solve2(coins,target-coins[i],dp);

            if(ans!=Integer.MAX_VALUE)
                mini=Math.min(mini,ans+1);
        }
        dp[target]=mini;
        return dp[target];
    }
    //Tabulation
    public static int solve3(int coins[], int target, int dp[]){
        //base condition
        Arrays.fill(dp,Integer.MAX_VALUE);
        dp[0]=0;
        //1st loop for every amount
        for(int i=1;i<=target;i++){
            //for every amount from
            for(int j=0;j<coins.length;j++){
                if(i-coins[j]>=0 && dp[i-coins[j]]!=Integer.MAX_VALUE)
                    dp[i]=Math.min(dp[i],dp[i-coins[j]]+1);
            }
        }
       if(dp[target]==Integer.MAX_VALUE)
           return -1;
        return dp[target];
    }
    public static void main(String[] args) {
      int coins[]={1,2,5};int target=11;
        System.out.println("--1. "+solve1(coins,target));
        int dp[]=new int[target+1];
        Arrays.fill(dp,-1);
        System.out.println("--2. "+solve2(coins,target,dp));
        System.out.println("--3. "+solve3(coins,target,dp));
    }
}
