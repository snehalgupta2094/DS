package DP;

import java.util.ArrayList;

public class CombinationSum {
   public static void solve(int[] nums, int target, ArrayList<ArrayList<Integer>> output, ArrayList<Integer> ans){
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
           solve(nums,target-nums[i],output,ans);
           ans.remove(ans.size()-1);
       }
   }
    public static void main(String[] args) {
        int nums[]={1,2,3};
        int target=4;
        ArrayList<ArrayList<Integer>> output=new ArrayList<>();
        solve(nums,target,output,new ArrayList<>());
        System.out.println(output);
    }
}
