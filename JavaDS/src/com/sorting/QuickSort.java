package com.sorting;

public class QuickSort {

	
	public void sort(int[] array, int start, int end)
	{
		if( start < end)
		{
			int partitionIndex= partition(array,start,end);
		
			sort(array,start,partitionIndex-1);
			sort(array,partitionIndex+1,end);
		}
	}
	
	public int partition(int[] array, int start, int end )
	{
		int pIndex, pivot;
		
		pivot=end;
		pIndex=start;
		
		for(int i=1;i <=end;i++)
		{
			if(array[i] <= pivot)
			{
				int temp = array[pIndex];
				array[pIndex] = array[i];
				array[i]=temp;
				pIndex++;
			}
		}
		int temp = array[pivot];
		array[pivot] = array[pIndex];
		array[pIndex] = temp;
		
		return pIndex;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] array = {7,6,5,4,3,2,1,0};	
		QuickSort quickSort= new QuickSort();
		
		quickSort.sort(array,0,array.length-1);
		
		for(int i=0; i< array.length-1;i++)
		{
			System.out.print(" " + array[i]);
		}
	}

}
