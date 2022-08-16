package Sorting;

import java.util.Arrays;

public class QuickSort
{
    public static void swap(int arr[], int i, int j){
        int temp=arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
    }
    public static int partition(int arr[],int s, int e){
        int pivot=arr[s];

        //place pivot in it's right place
        int count=0;
        for(int i=s+1;i<=e;i++){
            if(arr[i]<pivot)
                count++;
        }
        int pivotIndex=s+count;
        swap(arr,s,pivotIndex);

        //element to left of pivot should be less and right should be greater
        int i=s,j=e;
        while(i<pivotIndex && j>pivotIndex){
            while(arr[i]<arr[pivotIndex])
                i++;
            while(arr[j]>arr[pivotIndex])
                j--;
            swap(arr,i++,j--);
        }
        return pivotIndex;
    }
    public static void quickSort(int arr[], int s, int e){
        //base condition
        if(s>=e)
            return;
        //recursion
        int pivot=partition(arr,s,e);
        quickSort(arr,s,pivot-1);
        quickSort(arr,pivot+1,e);
    }
    public static void main(String[] args) {
        int arr[]={2,6,1,9,4,3,8};
        quickSort(arr,0,arr.length-1);
        System.out.println(Arrays.toString(arr));
    }
}
