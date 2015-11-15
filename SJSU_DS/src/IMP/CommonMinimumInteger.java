package IMP;

import java.util.HashSet;
import java.util.Set;

public class CommonMinimumInteger {
	
	// How do I find the lowest common duplicate in two large integer arrays with minimum time complexity?
	
	public static void main(String args[] )
	{
		
	}
	
	private static int findMinimum(int a[], int b[]){
		Set<Integer> s = new HashSet<Integer>();

		for (int i=0;  i<a.length; i++) {
		  s.add(a[i]);
		}

		int commonMin = Integer.MAX_VALUE;
		for (int i=0; i<b.length; i++) {
		  if (s.contains(b[i])) {
		    if (b[i] < commonMin){
		      commonMin = b[i];
		    }
		  }
		}

		return commonMin;
	}
	

}
