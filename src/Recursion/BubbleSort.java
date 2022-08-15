package Recursion;

import java.util.Arrays;

public class BubbleSort {
    public static void swap(int arr[], int i, int j){
        int temp=arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
    }
    public static void bubbleSort(int arr[], int j,int n){

        //base case
        if(j==n)
            return;
        //processing
        for(int i=0;i<n-1;i++){
            if (arr[i + 1] < arr[i]) {
               swap(arr,i,i+1);
            }
        }
        //recuurence
        bubbleSort(arr,j+1,n);

    }
    public static void main(String[] args) {
         int arr[]={2,5,1,6,9};
         bubbleSort(arr,0,arr.length);
        System.out.println(Arrays.toString(arr));
    }
}
