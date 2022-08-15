package Sorting;

import java.util.Arrays;

public class MergeSort {
    public static void merge(int arr[], int l,int mid, int h){
        int len1=mid-l+1;
        int len2=h-mid;
        //copy values
        int first[]=new int[len1];
        int second[]=new int[len2];
        int mainIndex=l;
        for(int i=0;i<len1;i++){
            first[i]=arr[mainIndex++];
        }
        mainIndex=mid+1;
        for(int i=0;i<len2;i++){
            second[i]=arr[mainIndex++];
        }
        //merge 2 sorted arrays
        int index1=0;
        int index2=0;
        mainIndex=l;
        while(index1<len1 && index2<len2){
            if(first[index1]<second[index2]){
                arr[mainIndex++]=first[index1++];
            }else{
                arr[mainIndex++]=second[index2++];
            }
        }
        while(index1<len1){
            arr[mainIndex++]=first[index1++];
        }
        while(index2<len2){
            arr[mainIndex++]=second[index2++];
        }
    }
    public static void solve(int arr[], int l, int h){
        if(l>=h)
            return;
        int mid=l+(h-l)/2;
        solve(arr,l,mid);
        solve(arr,mid+1,h);
        merge(arr,l,mid,h);

    }
    public static void main(String[] args) {
        int arr[]={2,5,6,1,3,9};
       solve(arr,0,arr.length-1);
        System.out.println(Arrays.toString(arr));
    }
}
