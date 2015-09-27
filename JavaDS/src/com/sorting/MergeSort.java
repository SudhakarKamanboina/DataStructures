package com.sorting;

import java.util.Arrays;

public class MergeSort {
	
	public void mergeSort(int[] sortArray)
	{
		if(sortArray.length < 2)
			return;
		int mid=sortArray.length/2;
		
		int[] left=new int[mid];
		int[] right=new int[sortArray.length-mid];
	
		left=Arrays.copyOfRange(sortArray,0, mid);
		right=Arrays.copyOfRange(sortArray,mid, sortArray.length);
		/*
		for(int i=0;i<= mid-1;i++)
		{
			left[i]=sortArray[i];
		}
		for(int i=mid;i<sortArray.length;i++)
		{
			right[i]=sortArray[i-mid];
		} */
		mergeSort(left);
		mergeSort(right);
		merge(left,right,sortArray);
	}
	
	public void merge(int[] left,int[] right,int[] sortArray)
	{
		int i=0,j=0,k=0;
		
		while(i < left.length && j < right.length)
		{
			if(left[i] < right[j])
			{
				sortArray[k]=left[i];
				i++;
			}
			else
			{
				sortArray[k]=right[j];
				j++;
			}
			k++;
		}	
			while(i< left.length)
			{
				sortArray[k]=left[i];
				i++;k++;
			}
			while(i< right.length)
			{
				sortArray[k]=right[j];
				j++;k++;
			}
	}
	
	public void printList(int[] sortArray)
	{
		for (int i=0;i<sortArray.length;i++)
		{
			System.out.print("  "+sortArray[i]);
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] sortArray={2,4,1,6,8,5,3,7};
		MergeSort mSort= new MergeSort();
		mSort.mergeSort(sortArray);
		mSort.printList(sortArray);
	}
}
