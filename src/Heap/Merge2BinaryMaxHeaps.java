package Heap;

import java.util.Arrays;

public class Merge2BinaryMaxHeaps {

    public static void heapify(int a[],int index, int size){
        int largest=index;
        int left=2*index+1;
        int right=2*index+2;

        if(left<size && a[largest]<a[left]){
            largest=left;
        }
        if(right<size && a[largest]<a[right]){
            largest=right;
        }
        if(largest!=index){
            int temp=a[largest];
            a[largest]=a[index];
            a[index]=temp;
            heapify(a,largest,size);
        }
    }
    public static void mergeHeap(int a[], int b[]){
        int m=a.length;
        int l=b.length;
        int c[]=new int[m+l];
        int k;
        //Step1: Merge 2 arrays
        for(k=0;k<m;k++)
        {
            c[k]=a[k];
        }
        for(int j=0;j<l;j++){
            c[k++]=b[j];
        }
        //Step2: Build heap
        for(int i=(k/2)-1;i>=0;i--){
            heapify(c,i,k);
        }
        System.out.println(Arrays.toString(c));
    }
    public static void main(String[] args) {
        int a[]={12,7,9};
        int b[]={10,5,6,2};
        mergeHeap(a,b);
    }
}
