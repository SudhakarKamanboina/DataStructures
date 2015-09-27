package com.sorting;

public class BubbleSort {

	int[] sortArray={723,34,1,4,26};
	
	public void sort()
	{
		System.out.println("Array length: "+sortArray.length);
		for (int k=0;k<(sortArray.length);k++)
		{
			for(int i=0;i<(sortArray.length-1);i++)
			{
				if(sortArray[i+1] < sortArray[i])
				{
					int temp=sortArray[i];
					sortArray[i]=sortArray[i+1];
					sortArray[i+1]= temp;
				}
			}
	
		}
		print();
	}
	
	
	public void efficientSort()
	{
		System.out.println("Array length: "+sortArray.length);
		for (int k=0;k<(sortArray.length);k++)
		{
			boolean flag=false;
			for(int i=0;i<(sortArray.length-k-1);i++)
			{
				if(sortArray[i+1] < sortArray[i])
				{
					int temp=sortArray[i];
					sortArray[i]=sortArray[i+1];
					sortArray[i+1]= temp;
					flag=true;
				}
			}
			if(!flag)
				break;
		}
		print();
	}
	
	public void print()
	{
		for (int i=0;i<sortArray.length;i++)
		{
			System.out.print("  "+sortArray[i]);
		}
	}
	
	public static void main(String[] agrs)
	{
		BubbleSort bsort= new BubbleSort();
		bsort.efficientSort();
	}
	
}
