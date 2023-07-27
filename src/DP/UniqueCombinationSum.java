package DP;

import java.util.ArrayList;
import java.util.Arrays;

public class UniqueCombinationSum {
    public static void findCombinations(int[] nums, int target, ArrayList<ArrayList<Integer>> output, ArrayList<Integer> ans, int index){
        if(target==0)
        {
            output.add(new ArrayList<>(ans));
            return;
        }
        if(target<0){
            return;
        }
        for(int i=0;i<nums.length;i++) {

            ans.add(nums[index]);
            findCombinations(nums, target - nums[index], output, ans, index + 1);
            ans.remove(ans.size() - 1);
        }

    }
    public static void main(String[] args) {
        int candidates[] = {10,1,2,7,6,1,5};
        int target = 8;
        ArrayList<ArrayList<Integer>> output=new ArrayList<>();
        findCombinations(candidates,target,output,new ArrayList<>(),0);
        System.out.println(output);


    }
}
