package Searching;

public class LinearSearchRecursive {

    public static boolean search(int arr[],int i, int key){
        //Base condition
        if(i==arr.length)
            return false;
        if(arr[i]==key)
            return true;
        //Recursive relation (Tail recursion)
        return search(arr,i+1,key);
    }
    public static void main(String[] args) {
       int arr[]={2,1,3,4,6,7};
        System.out.println(search(arr,0,9));
    }
}
