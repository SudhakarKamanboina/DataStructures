package IMP;

public class LargestContinousSum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a[] =  {-2, -3, 4, -1, -2, 1, 5, -3};
		System.out.println(maxSubArraySum(a));
	}
	
	private static int maxSubArraySum(int a[])
	{
	   int max_so_far = a[0];
	   int curr_max = a[0];
	 
	   for (int i = 1; i < a.length; i++)
	   {
	        curr_max = max(a[i], curr_max+a[i]);
	        max_so_far = max(max_so_far, curr_max);
	        System.out.println("currmax: "+curr_max+"  max: "+max_so_far);
	   }
	   return max_so_far;
	}
	 
	private static int max(int a, int b)
	{
		return  (a > b) ? a: b;
	}
	

}
