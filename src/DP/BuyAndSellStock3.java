package DP;

public class BuyAndSellStock3 {
    //Recursion
    public static int solve(int prices[],int i, int buy, int limit){
        if(i==prices.length)
            return 0;
        if(limit==0)
            return 0;
        int profit=0;
        if(buy==1){
            int buyKaro=-prices[i]+ solve(prices,i+1,0,limit);
            int skipKaro=0+solve(prices,i+1,1,limit);
            profit=Math.max(buyKaro,skipKaro);
        }
        else
        {
            int sellKaro=prices[i]+ solve(prices,i+1,1,limit-1);
            int skipKaro=0+solve(prices,i+1,0,limit);
            profit=Math.max(sellKaro,skipKaro);
        }
        return profit;
    }
    //Recursion+memoization
    public static int solve1(int prices[],int i, int buy, int dp[][][], int limit){
        if(i==prices.length)
            return 0;
        if(limit==0)
            return 0;
        if(dp[i][buy][limit]!=-1)
            return dp[i][buy][limit];
        int profit=0;
        if(buy==1){
            int buyKaro=-prices[i]+ solve1(prices,i+1,0,dp,limit);
            int skipKaro=0+solve1(prices,i+1,1,dp,limit);
            profit=Math.max(buyKaro,skipKaro);
        }
        else
        {
            int sellKaro=prices[i]+ solve1(prices,i+1,1,dp,limit-1);
            int skipKaro=0+solve1(prices,i+1,0,dp,limit);
            profit=Math.max(sellKaro,skipKaro);
        }
        return dp[i][buy][limit]=profit;
    }
    //Tabulation
    public static int solve2(int prices[]){
        int dp[][][]=new int[prices.length+1][2][3];

        for(int i=prices.length-1;i>=0;i--){
            for(int buy=0;buy<=1;buy++){
                //agr limit 0 has to answer 0 so it is starting from 1
                for(int limit=1;limit<=2;limit++){
                    int profit=0;
                    if(buy==1){
                        int buyKaro=-prices[i]+ dp[i+1][0][limit];
                        int skipKaro=0+dp[i+1][1][limit];
                        profit=Math.max(buyKaro,skipKaro);
                    }
                    else
                    {
                        int sellKaro=prices[i]+ dp[i+1][1][limit-1];
                        int skipKaro=0+dp[i+1][0][limit];
                        profit=Math.max(sellKaro,skipKaro);
                    }
                    dp[i][buy][limit]=profit;
                }

            }
        }
        return dp[0][1][2];
    }
    //Space optimization
    public static int solve3(int prices[]){

        int next[][]=new int[2][3];
        int curr[][]=new int[2][3];

        for(int i=prices.length-1;i>=0;i--){
            for(int buy=0;buy<=1;buy++){
                //agr limit 0 has to answer 0 so it is starting from 1
                for(int limit=1;limit<=2;limit++){
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
        return next[1][2];
    }
    public static void main(String[] args) {
        int[] prices={3,3,5,0,0,3,1,4};
        System.out.println(solve(prices,0,1,2));
        int dp[][][]=new int[prices.length][2][3];
        for(int i=0;i<prices.length;i++){
            for(int j=0;j<2;j++){
                for(int k=0;k<3;k++){
                    dp[i][j][k]=-1;
                }
            }
        }
        System.out.println(solve1(prices,0,1,dp,2));
        System.out.println(solve2(prices));
        System.out.println(solve3(prices));
    }
}
