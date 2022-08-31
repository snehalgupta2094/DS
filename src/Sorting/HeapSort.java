package Sorting;

import java.util.Arrays;

class Heaps{
    private void swap(int arr[],int i, int j) {
        int temp=arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
    }
    public void heapify(int arr[], int size, int i){
      int largest=i;
      int leftChild=2*i+1;
      int rightChild=2*i+2;

      if(leftChild<size && arr[largest]<arr[leftChild]){
        largest=leftChild;
      }
      if(rightChild<size && arr[largest]<arr[rightChild]){
        largest=rightChild;
      }

        if(largest!=i){
            swap(arr,largest,i);
            heapify(arr,size,largest);
        }
    }
    public void sort(int a[]){
        // Step1: build max heap/heapify
        int n=a.length;
        for(int i=(n/2)-1;i>=0;i--){
            heapify(a,n,i);
        }
        System.out.println(Arrays.toString(a));
        int size=n-1;
        while(size>0) {
            //Step2: swap root and last node
            swap(a, size, 0);

            //Step3: heapify
            heapify(a, size, 0);
            size--;
        }
        System.out.println(Arrays.toString(a));

    }
}
public class HeapSort {

    public static void main(String[] args) {
        int a[]={23,11,89,4,6,13,77};
        Heaps h=new Heaps();
        h.sort(a);
    }
}
