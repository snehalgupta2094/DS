package Heap;

import java.util.Arrays;

class Heap{
    int arr[]=new int[100];
    int size;
    Heap(){
        arr[0]=-1;
        size=0;
    }
    public  void print(){
        for (int i = 1; i <=size; i++) {
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }
    //Insert new node at end in heap
    public void insert(int val){
        //Step1: Insert new node at leaf
        size=size+1;
        arr[size]=val;

        //Step2: Take it to its correct position
        int i=size;
        while(i>1){
            int parent=i/2;
            if(arr[parent]>arr[i]){
                swap(i,parent);
                i=parent;
            }
            else
            {
                return;
            }
        }
    }

    private void swap(int i, int j) {
        int temp=arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
    }
    private void swap(int arr[],int i, int j) {
        int temp=arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
    }
    //Delete min from heap root element
    public void delete(){

        if(size==0)
            return;
        //Step1: copy last node to root
        arr[1]=arr[size];
        size=size-1;

        //Step2: Take root node to its correct position
        int i=1;
        while(i<size){
            int left=2*i;
            int right=2*i+1;
            if(left<size && arr[left]<arr[i]){
                swap(i,left);
                i=left;
            }else if(right<size && arr[right]<arr[i]){
                swap(i,right);
                i=right;
            }else{
                return;
            }
        }
    }
    //i is the index of element which we want to heapify fom n/2 to 0
    public void heapify(int arr[],int i, int n){
        int smallest=i;
        int leftChild=2*i+1;
        int rightChild=2*i+2;

        if(leftChild<n && arr[smallest]>arr[leftChild]){
            smallest=leftChild;
        }
        if(rightChild<n && arr[smallest]>arr[rightChild]){
            smallest=rightChild;
        }

        if(smallest!=i){
            swap(arr,smallest,i);
            heapify(arr,smallest,n);
        }
    }
}
public class MinHeap {

    public static void main(String[] args) {
        Heap minHeap=new Heap();

        System.out.println("--Insertion--");
        minHeap.insert(29);
        minHeap.insert(71);
        minHeap.insert(54);
        minHeap.insert(12);
        minHeap.insert(98);
        minHeap.insert(23);
        minHeap.print();

        System.out.println("--Deletion--");
        //minHeap.delete();
        minHeap.delete();
        minHeap.print();

        //build heap
        int a[]={23,11,89,4,6,13,77};
       int n=a.length;
        for(int i=(n/2)-1;i>=0;i--){
            minHeap.heapify(a,i,n);
        }
        System.out.println("--Heapify--");
        for (int i = 0; i <n; i++) {
            System.out.print(a[i]+" ");
        }
        System.out.println();

    }
}
