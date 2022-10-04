package Sorting;

import java.util.Arrays;


public class BubbleSort 
{
	public static void main(String[] args) 
	{
		int a[]= {7, 2, 9, 2, 5, 6};

		for(int pass=0;pass<a.length;pass++)
		{
			boolean flag=false;
			for(int i=0;i<a.length-i-1;i++)
			{
				if(a[i]>a[i+1])
				{
					flag=true;
					int temp=a[i];
					a[i]=a[i+1];
					a[i+1]=temp;
				}
			}
			//if no swapping array is sorted
			if(!flag)
				break;
		}
		System.out.println(Arrays.toString(a));
	}
}
