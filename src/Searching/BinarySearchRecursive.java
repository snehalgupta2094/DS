package Searching;

public class BinarySearchRecursive {
public static boolean search(int l, int h, int arr[], int key){
    if(l>h)
        return false;
    int mid=l+(h-l)/2;
    if(arr[mid]==key)
        return true;

    if(arr[mid]>key)
        return search(l,mid-1,arr,key);
    else
        return search(mid+1,h,arr,key);
}
    public static void main(String[] args) {
        int arr[]={2,1,3,4,6,7};
        System.out.println(search(0,arr.length-1,arr,9));
    }
}
