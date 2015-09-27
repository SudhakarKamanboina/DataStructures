package com.sorting;

public class CountingSort {

	int[] a={3,1,2,1,2,3};
	int[] b,c;
	
	public CountingSort() {
		// TODO Auto-generated constructor stub
		
		b= new int[a.length];
		c= new int[3];
	}
	
	public void sort()
	{
		initialize();
		
		for (int i=1; i<=a.length;i++)
		{
			c[a[i-1]-1]=c[a[i-1]-1] +1;
		}
	
		System.out.println("Array C contains number of times element appears in input");
		
		
		for(int j=2;j<= (c.length);j++)
		{
			c[j-1]=c[j-2]+c[j-1];
		}
		
		for(int k=(a.length);k>=1;k--)
		{
			b[c[a[k-1]-1]-1] =a[k-1];
			c[a[k-1]-1]=c[a[k-1]-1]-1;
		}
		
		for(int i=0;i<b.length;i++)
		{
			System.out.println(" "+b[i]);
		}
	}
	
	
	public void initialize()
	{
		for(int i=1;i<=c.length;i++ )
		{
			c[i-1]=0;
		}
	}
	
	public static void main(String[] args)
	{
		CountingSort cSort=new CountingSort();
		cSort.sort();
	}
	
}
