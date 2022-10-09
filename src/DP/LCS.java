package DP;

import java.util.Arrays;
import java.util.stream.Stream;

public class LCS 
{
	//Recursion
	public static int solve(String a, String b, int i, int j){
		if(i==a.length() || j==b.length())
			return 0;
		if(a.charAt(i)==b.charAt(j))
			return 1+solve(a,b,i+1,j+1);
		else
			return Math.max(solve(a,b,i+1,j),solve(a,b,i,j+1));
	}
	//Recursion+Memoization
	public static int solve1(String a, String b, int i, int j, int dp[][]){
		if(i==a.length() || j==b.length())
			return 0;
		if(dp[i][j]!=-1)
			return dp[i][j];
		int ans;
		if(a.charAt(i)==b.charAt(j))
			ans= 1+solve1(a,b,i+1,j+1,dp);
		else
			ans= Math.max(solve1(a,b,i+1,j,dp),solve1(a,b,i,j+1,dp));
		return dp[i][j]=ans;
	}
	//Tabulation
	public static int solve2(String a, String b){
		int dp[][]=new int[a.length()+1][b.length()+1];
		for(int i=a.length()-1;i>=0;i--)
			for(int j=b.length()-1;j>=0;j--) {
				if (a.charAt(i) == b.charAt(j))
					dp[i][j] = 1+dp[i+1][j+1];
				else
					dp[i][j] = Math.max(dp[i+1][j], dp[i][j+1]);
			}
		return dp[0][0];
	}
	//Space optimization
	public static int solve3(String a, String b){
		int next[]=new int[b.length()+1];
		int curr[]=new int[b.length()+1];
		for(int i=a.length()-1;i>=0;i--){
			int ans=0;
			for(int j=b.length()-1;j>=0;j--) {
				if (a.charAt(i) == b.charAt(j))
					ans = 1+next[j+1];
				else
					ans = Math.max(next[j], curr[j+1]);
				curr[j]=ans;
			}
			next=curr;
		}

		return next[0];
	}
	public static void dpsol(String s1, String s2)
	{
		char b[]=s1.toCharArray();
		char a[]=s2.toCharArray();
		int res[][]=new int[a.length+1][b.length+1];
		String sol[][]=new String[a.length][b.length];
		for(int i=0;i<a.length;i++)
		{
			for(int j=0;j<b.length;j++)
			{
				if(a[i]==b[j])
				{
					res[i+1][j+1]=res[i][j]+1;
					sol[i][j]="diagonal";
				}
				else
				{
					res[i+1][j+1]=Math.max(res[i+1][j], res[i][j+1]);
					sol[i][j]=res[i+1][j+1]==res[i][j+1]?"top":"left";
				}
			}
		}
		Stream.of(sol).map(Arrays::toString).forEach(System.out::println);
		String ans="";
		int i=a.length-1, j=b.length-1;
		while(i>=0 && j>=0)
		{
			if(sol[i][j].equals("diagonal"))
			{
				ans=a[i]+ans;
				i--;j--;
			}
			else if(sol[i][j].equals("top"))
			{
				i--;
			}
			else
				j--;
		}
		System.out.println(ans);
	}
	public static void main(String[] args) 
	{
		String s1="snehalgupta";
		String s2="sunyegat";
		System.out.println(solve(s1,s2,0,0));
		int dp[][]=new int[s1.length()][s2.length()];
		for(int i=0;i<s1.length();i++)
			for(int j=0;j<s2.length();j++)
				dp[i][j]=-1;
		System.out.println(solve1(s1,s2,0,0,dp));
		System.out.println(solve2(s1,s2));
		System.out.println(solve3(s1,s2));
	}
	
	
}
