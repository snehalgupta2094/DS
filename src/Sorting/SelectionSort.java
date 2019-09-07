package Sorting;

import java.util.Arrays;
import java.util.stream.Stream;

public class SelectionSort 
{
	public static void main(String[] args) 
	{
		int a[]= {7, 2, 9, 3, 5, 6};
		
		for(int i=0;i<a.length-1;i++)
		{
			for(int j=i+1;j<a.length;j++)
			{
				if(a[i]>a[j])
				{
					int temp=a[i];
					a[i]=a[j];
					a[j]=temp;
				}
			}
		}
		Arrays.stream(a).forEach(System.out::println);
	}
}
