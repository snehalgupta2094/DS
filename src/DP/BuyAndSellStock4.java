package DP;


public class BuyAndSellStock4 {

    //Space optimization
    public static int solve3(int prices[], int k){

        int next[][]=new int[2][k+1];
        int curr[][]=new int[2][k+1];

        for(int i=prices.length-1;i>=0;i--){
            for(int buy=0;buy<=1;buy++){
                //agr limit 0 has to answer 0 so it is starting from 1
                for(int limit=1;limit<=k;limit++){
                    int profit=0;
                    if(buy==1){
                        int buyKaro=-prices[i]+next[0][limit];
                        int skipKaro=0+next[1][limit];
                        profit=Math.max(buyKaro,skipKaro);
                    }
                    else
                    {
                        int sellKaro=prices[i]+ next[1][limit-1];
                        int skipKaro=0+next[0][limit];
                        profit=Math.max(sellKaro,skipKaro);
                    }
                    curr[buy][limit]=profit;
                }
            }
            next=curr;
        }
        return next[1][k];
    }
    public static void main(String[] args) {
        int[] prices={3,2,6,5,0,3};
        int k=2;
        System.out.println(solve3(prices,k));
    }
}
