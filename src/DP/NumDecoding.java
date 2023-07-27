package DP;

import java.util.ArrayList;
import java.util.Arrays;

public class NumDecoding {
    public static int numDecodings(String nums, int index, int n) {
        if(index==n){
            return 1;
        }
        if(nums.charAt(index)=='0')
            return 0;
        int way1=numDecodings(nums,index+1,n);
        int way2=0;
        if(index<n-1 && Integer.parseInt(nums.substring(index,index+2))<=26)
           way2=numDecodings(nums,index+2,n);
        return way1+way2;
    }
    public static void main(String[] args) {
       String nums="226";
       int n=nums.length();
        System.out.println( numDecodings(nums,0,n));
    }
}
