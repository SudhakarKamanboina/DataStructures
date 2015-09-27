package com.sorting;

public class SelectionSort {

	int[] sortArray={7,4,1,3,2};
	
	public void sort()
	{
		int i,min,j;
		for(i=0; i<sortArray.length-1;i++)
		{
			min=i;
			for (j=i+1;j<sortArray.length;j++)
			{
				if(sortArray[j] < sortArray[min])
				{
					min=j;
				}
			}
			int temp=sortArray[i];
			sortArray[i]=sortArray[min];
			sortArray[min]=temp;
		}
		printList();
	}
	
	public void printList()
	{
		for(int i=0;i<sortArray.length;i++)
		{
			System.out.print("  "+sortArray[i]);
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		SelectionSort  sSort= new SelectionSort();
		sSort.sort();
	}

}
