package paypal;

public class MaximumDifference {
	
	/*Maximum difference between two elements such that larger element appears after the smaller number
	Given an array arr[] of integers, find out the difference between any two elements such that larger element appears after the smaller number in arr[].

	Examples: If array is [2, 3, 10, 6, 4, 8, 1] then returned value should be 8 (Diff between 10 and 2). If array is [ 7, 9, 5, 6, 3, 2 ] then returned value should be 2 (Diff between 7 and 9)
*/
	public static void main(String[] args) {
		int[] a = {2, 3, 10, 6, 4, 8, 1};
		System.out.println("diff using min method: "+difference1(a));
		System.out.println("diff using max method: "+difference2(a));
	}
	
	// using min
	private static int difference1(int[] a)
	{
		int diff = 0;
		int min = a[0];
		
		for(int i=1; i<a.length; i++)
		{
			if(a[i] < min)
			{
				min = a[i];
			}
			
			if(a[i]-min > diff)
			{
				diff = a[i] - min;
			}
		}
		return diff;
	}
	

	// using max
		private static int difference2(int[] a)
		{
			int diff = 0;
			int max = a[a.length-1];
			
			for(int i=a.length-2; i>=0; i--)
			{
				if(a[i] > max)
				{
					max = a[i];
				}
				
				if(max - a[i] > diff)
				{
					diff = max - a[i];
				}
			}
			return diff;
		}
}
