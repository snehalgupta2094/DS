package Sorting;

import java.util.Arrays;


public class BubbleSort 
{
	public static void main(String[] args) 
	{
		int a[]= {7, 2, 9, 2, 5, 6};
		
		for(int pass=0;pass<a.length;pass++)
		{
			for(int i=0;i<a.length-1;i++)
			{
				if(a[i]>a[i+1])
				{
					int temp=a[i];
					a[i]=a[i+1];
					a[i+1]=temp;
				}
			}
		}
		Arrays.stream(a).forEach(System.out::println);
	}
}
