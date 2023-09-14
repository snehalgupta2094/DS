package Arrays;

import java.util.Arrays;

public class ReverseAnArray {

    public static void main(String[] args) {
        int arr[]={9,5,1,11,7,4,2};
        int start=0;
        int end=arr.length-1;
        while(start<=end){
            int temp=arr[start];
            arr[start]=arr[end];
            arr[end]=temp;
            start++;
            end--;
        }
        System.out.println(Arrays.toString(arr));
    }
}
