package Recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PowerSet {
    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> list=new ArrayList<>();
        List<Integer> output=new ArrayList<>();
        subset(nums,output,0,list);
        return list;
    }

    public static void subset(int[] nums, List<Integer> output, int index, List<List<Integer>> list){

        //base case
        if(index>=nums.length){
            list.add(new ArrayList<>(output));
            return;
        }

        //exclude
        subset(nums,output,index+1,list);

        //include
        int ele=nums[index];
        output.add(ele);
        subset(nums,output,index+1,list);
        output.remove(output.size()-1);

        return;
    }
    public static void main(String[] args) {
        int nums[]={1,2,3};
     List<List<Integer>> list= subsets(nums);
       System.out.println(list);
    }
}
