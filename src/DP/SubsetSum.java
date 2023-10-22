package DP;

public class SubsetSum {

    public static boolean sum(int target, int index, int n, int arr[]){
        if(target==0)
            return true;

        if(index==n || target<0)
            return false;

        return sum(target-arr[index], index+1, n,arr) || sum(target,index+1,n,arr);
    }
    public static void main(String[] args) {
        int arr[]={1,0,5,4,9};
        if(sum(17,0,arr.length,arr)){
            System.out.println("subset exist");
        }
        else{
            System.out.println("no subset");
        }
    }

}
