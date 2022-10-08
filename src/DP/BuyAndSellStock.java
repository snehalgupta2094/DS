package DP;

public class BuyAndSellStock {

    public static void main(String[] args) {
    int[] prices={7,1,5,3,6,4};
    int min=prices[0];
    int profit=0;
    for(int i=1;i<prices.length;i++){
        int diff=prices[i]-min;
        min=Math.min(min,prices[i]);
        profit=Math.max(profit,diff);
    }
        System.out.println(profit);
    }
}
