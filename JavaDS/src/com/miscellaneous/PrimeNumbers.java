package com.miscellaneous;

public class PrimeNumbers {

	public static int getPrimes(int N)
	{
		 int count=0;
		    boolean flag;
		    
		    for (int i=2;i<N;i++)
		        {
		            flag=false;
		            for(int j=2;j<i;j++)
		                {
		                if(i%j==0)
		                    {
		                    flag=true; 
		                }
		            }
		        if(!flag)
		            count++;
		    }

		    return count;
	}
	
	
	public static void main(String[] args)
	{
		int num= PrimeNumbers.getPrimes(10);
		System.out.println(num);
	}
}
