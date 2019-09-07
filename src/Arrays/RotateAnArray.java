package Arrays;

import java.util.Arrays;
import java.util.stream.Stream;

public class RotateAnArray 
{
	public static void main(String[] args) 
	{
		int arr[]= {4, 1, 2, 3, 5};
		int k=3;
		if(k>arr.length)
			k=k%arr.length;
		reverseArray(arr,0,k-1);
		reverseArray(arr,k,arr.length-1);
		reverseArray(arr,0,arr.length-1);
		System.out.println();
		Arrays.stream(arr).forEach(p->System.out.print(p+" "));
	}

	private static void reverseArray(int[] arr, int l, int h) 
	{
		while(l<h)
		{
			int tmp=arr[l];
			arr[l]=arr[h];
			arr[h]=tmp;
			l++;
			h--;
		}
	}

}
