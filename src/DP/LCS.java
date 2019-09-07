package DP;

import java.util.Arrays;
import java.util.stream.Stream;

public class LCS 
{
	public static void main(String[] args) 
	{
		String s1="snehalgupta";
		String s2="sunyegat";
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
	
	
}
