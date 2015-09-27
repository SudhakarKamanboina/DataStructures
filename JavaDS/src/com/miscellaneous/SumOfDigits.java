package com.miscellaneous;

public class SumOfDigits {

	
	public int getSum(int result)
	{
		if((result/10) > 0)
		{		
			return (result%10 + getSum(result/10));
		}
		else return result;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SumOfDigits sumOfDigits = new SumOfDigits();
		System.out.println("Sum of digits "+sumOfDigits.getSum(1234));
	}
}
