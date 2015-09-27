package com.miscellaneous;

public class PowerFunction {

	public int pow(int base, int exp)
	{
		int output=1;
		if(exp==0)
		{
			return 1;
		}
		if(base==0)
		{
			return 0;
		}
		for(int i=1;i<=exp;i++)
		{
			output=output*base;
		}
		return output;
	}
	
	public int recurPow(int base, int exp)
	{
		if(exp==0)
		{
			return 1;
		}
		if(base==0)
		{
			return 0;
		}
		if(exp==1)
		{
			return base;
		}
		return base*pow(base,exp-1);
	}
	
	
	public static void main(String[] args)
	{
		PowerFunction powfunc = new PowerFunction();
		
		System.out.println("Non recursive :" + powfunc.pow(2,3));
		System.out.println("recursive :"+ powfunc.pow(2, 3));
	}
}
