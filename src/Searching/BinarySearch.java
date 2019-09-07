package Searching;
public class BinarySearch 
{
	public static void main(String[] args) 
	{
		int a[]= {1, 2, 3, 4, 5, 6, 7, 8};
		int pos=binSearch(a, 0,(a.length)-1,5);
		System.out.println(pos);
		int pos1=binSearch(a,4);
		System.out.println(pos1);
	}
	private static int binSearch(int[] a, int data) {
		int high=a.length-1;
		int low=0;

		while(low<high)
		{
			int mid=((high-low)/2)+low;
			if(a[mid]==data)
				return mid;
			else if(a[mid]>data)
				high=mid-1;
			else 
				low=mid+1;
		}
		return -1;
	}
	public static int binSearch(int a[], int low, int high, int data){
		int mid=((high-low)/2)+low;
		if(a[mid]==data)
			return mid;
		else if(a[mid]>data)
			return binSearch(a, low, mid-1, data);
		else 
			return binSearch(a, mid+1, high, data);
	}
}
