package Sorting;

import java.util.Arrays;

public class InsertionSort
{
	public static void main(String[] args) 
	{
		int a[]= {1, 7, 2, 9, 4, 5, 6};
		for(int i=1;i<a.length;i++)
		{
			int temp=a[i];//element ko uske left mein daalna hai correct position par agr wo element chota hai and remaining elements ko shift krna hai to the right
			int j=i-1;
			for(;j>=0;j--){
			     	if(a[j]>temp) {
					     //shift
					a[j+1]=a[j];
				}
				     else{
					     break;
				}
			}
			a[j+1]=temp;
		}
		System.out.println("" + Arrays.toString(a));
	}
}
