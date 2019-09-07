package Searching;

public class LinearSearch 
{
	public static void main(String[] args) 
	{
		int a[]= {1, 2, 3, 4, 5, 6, 7, 8};
		int pos=linearSearch(a,5);
		System.out.println(pos);
	}

	private static int linearSearch(int[] a, int data) {
		for(int i=0;i<a.length;i++)
		{
			if(a[i]==data)
				return i;
		}
		return -1;
	}
}
