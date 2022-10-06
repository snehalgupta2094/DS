package DP;

import java.util.Arrays;

public class Knapsack {

    //Recursion
public static int knapsack(int[] value, int[] weight, int capacity, int index){
    //base case
    if(index==0)
    if(weight[0]<=capacity)
        return value[0];
    else
        return 0;

    //include
    int include=0;
    if(weight[index]<=capacity){
        include=value[index]+knapsack(value,weight,capacity-weight[index],index-1);
    }
    int exclude=0+knapsack(value,weight,capacity,index-1);
    return Math.max(include,exclude);
}
    //Recursion+memoization
    public static int knapsack1(int[] value, int[] weight, int capacity, int index, int dp[][]){
        //base case
        if(index==0)
            if(weight[0]<=capacity)
                return value[0];
            else
                return 0;

            if(dp[index][capacity]!=-1)
                return dp[index][capacity];
        //include
        int include=0;
        if(weight[index]<=capacity){
            include=value[index]+knapsack1(value,weight,capacity-weight[index],index-1,dp);
        }
        int exclude=0+knapsack1(value,weight,capacity,index-1,dp);
        dp[index][capacity]=Math.max(include,exclude);
        return dp[index][capacity];
 }
 //tabulation
    public static int knapsack2(int[] value, int[] weight, int capacity, int n){
        int dp[][]=new int[n][capacity+1];
        for(int i=0;i<n;i++)
            for(int j=0;j<=capacity;j++)
                dp[i][j]=0;
        //base case
            for(int w=weight[0];w<=capacity;w++){
                if(dp[0][w]<=capacity)
                    dp[0][w]=value[0];
                else
                    dp[0][w]=0;
            }
        //include
        for(int i=1;i<n;i++)
        {
            for(int w=0;w<=capacity;w++){
                int include=0;
                if(weight[i]<=w){
                    include=value[i]+dp[i-1][w-weight[i]];
                }
                int exclude=dp[i-1][w];
                dp[i][w]=Math.max(include,exclude);
            }
        }
    return dp[n-1][capacity];
    }
    //space optimization
    public static int knapsack3(int[] value, int[] weight, int capacity, int n){
        int prev[]=new int[capacity+1];
        int curr[]=new int[capacity+1];
        //base case
        for(int w=weight[0];w<=capacity;w++){
            if(prev[w]<=capacity)
                prev[w]=value[0];
            else
                prev[w]=0;
        }
        //include
        for(int i=1;i<n;i++)
        {
            for(int w=0;w<=capacity;w++){
                int include=0;
                if(weight[i]<=w){
                    include=value[i]+prev[w-weight[i]];
                }
                int exclude=prev[w];
                curr[w]=Math.max(include,exclude);
            }
            prev=curr;
        }
        return prev[capacity];
    }
    //space optimization2
    public static int knapsack4(int[] value, int[] weight, int capacity, int n){
        int curr[]=new int[capacity+1];
        //base case
        for(int w=weight[0];w<=capacity;w++){
            if(curr[w]<=capacity)
                curr[w]=value[0];
            else
                curr[w]=0;
        }
        //include
        for(int i=1;i<n;i++)
        {
            for(int w=capacity;w>=weight[0];w--){
                int include=0;
                if(weight[i]<=w){
                    include=value[i]+curr[w-weight[i]];
                }
                int exclude=curr[w];
                curr[w]=Math.max(include,exclude);
            }
        }
        return curr[capacity];
    }
    public static void main(String[] args) {
        int[] value={5,4,8,6};
        int[] weight={1,2,4,5};
        int capacity=5;
        int n=4;
        int dp[][]=new int[n][capacity+1];
        for(int i=0;i<n;i++)
            for(int j=0;j<=capacity;j++)
                dp[i][j]=-1;
        System.out.println(knapsack(value,weight,capacity,n-1));
        System.out.println(knapsack1(value,weight,capacity,n-1,dp));
        System.out.println(knapsack2(value,weight,capacity,n));
        System.out.println(knapsack3(value,weight,capacity,n));
        System.out.println(knapsack4(value,weight,capacity,n));
    }
}
