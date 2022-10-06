package DP;

import java.util.ArrayList;
import java.util.Arrays;

public class CombinationSum {
    //Recursion
   public static void findCombinations(int[] nums, int target, ArrayList<ArrayList<Integer>> output, ArrayList<Integer> ans){
       if(target==0)
       {
           output.add(new ArrayList<>(ans));
           return;
       }
       if(target<0){
           return;
       }

       for(int i=0;i<nums.length;i++){
           ans.add(nums[i]);
           findCombinations(nums,target-nums[i],output,ans);
           ans.remove(ans.size()-1);
       }
   }
   //Recursion+memoization
    static int ans=0;
    public static int solve1(int[] nums, int target, int dp[]){
        if(target==0)
        {
            return 1;
        }
        if(target<0){
            return 0;
        }
        if(dp[target]!=-1)
            return dp[target];
        for(int i=0;i<nums.length;i++){
            ans+= solve1(nums,target-nums[i],dp);
        }
        dp[target]=ans;
        return dp[target];
    }
    //tabulation
    public static int solve2(int[] nums, int target){
        int n=nums.length;
        int dp[]=new int[target+1];
        dp[0]=1;
        for(int i=1;i<=target;i++){
            for(int j=0;j<n;j++){
                if(i-nums[j]>=0)
                    dp[i]+= dp[i-nums[j]];
            }
        }

        return dp[target];
    }
    public static void main(String[] args) {
        int nums[]={1,2,3};
        int target=4;
        ArrayList<ArrayList<Integer>> output=new ArrayList<>();
        findCombinations(nums,target,output,new ArrayList<>());
        System.out.println(output);
        int dp[]=new int[target+1];
        Arrays.fill(dp, -1);
        System.out.println(solve1(nums,target,dp));
        System.out.println(solve2(nums,target));
    }
}
