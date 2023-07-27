package Backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Permutation {
    public static void solve(List<List<Integer>> ans, int[] nums, int index){
        //base case
        if(index>=nums.length){
            List<Integer> intList = new ArrayList<Integer>(nums.length);
            for (int i : nums)
            {
                intList.add(i);
            }
            ans.add(intList);
            return;
        }
        for(int i=index;i<nums.length;i++){
            swap(nums,index,i);
            System.out.println( Arrays.toString(nums));
            solve(ans,nums,index+1);
            //backtrack
            swap(nums,i,index);
        }
    }
    public static void swap(int nums[],int i,int j){
        int temp=nums[i];
        nums[i]=nums[j];
        nums[j]=temp;
    }
    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans=new ArrayList<>();
        solve(ans,nums,0);
        return ans;
    }

    public static void main(String[] args) {
        int nums[]={1,2,3};
        System.out.println(permute(nums));
    }
}
