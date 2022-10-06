package DP;

public class Knapsack {

public static int knapsack(int[] value, int[] weight, int capacity, int index){
    //base case
    if(index==0)
    if(weight[0]<=capacity)
        return value[0];
    else
        return 0;

    //include
    int include=0;
    if(weight[index]<=capacity){
        include=value[index]+knapsack(value,weight,capacity-weight[index],index-1);
    }
    int exclude=0+knapsack(value,weight,capacity,index-1);
    return Math.max(include,exclude);

}

    public static void main(String[] args) {
        int[] value={5,4,8,6};
        int[] weight={1,2,4,5};
        int capacity=5;
        int n=4;
        System.out.println(knapsack(value,weight,capacity,n-1));
    }
}
