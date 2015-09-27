package com.sorting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class InsertionSort {

	int[] sortArray={756,3,1,265,4,2};
	
	
	public InsertionSort() {
		// TODO Auto-generated constructor stub
		//sortArray=new int[30]; 
	}
	
	
	public void insert(int num)
	{
		int temp,j;
		for(int i=0;i< sortArray.length;i++)
		{
			temp=sortArray[i];
			for( j=i-1;j>=0 && temp < sortArray[j];j--)
			{
				sortArray[j+1]=sortArray[j];
				//sortArray[j]=temp;
			}
			sortArray[j+1]=temp;
		}
		printList();
	}

	
	public void insertionSort()
	{
		int hole=0,value;
		
		for(int i=1;i<sortArray.length;i++)
		{	
			hole= i;
			value=sortArray[hole];
			while(hole >0 && sortArray[hole-1] > value)
			{
				sortArray[hole]=sortArray[hole-1];
				hole=hole-1;
			}
			sortArray[hole]=value;
		}
		printList();
	}
	
	public void printList()
	{
		System.out.println("Sorted Array");
		for (int i=0;i<sortArray.length;i++)
		{
			System.out.print("   "+sortArray[i]);
		}
		
	}
	
	
	public static void main(String args[]) throws IOException
	{
			
		//System.out.println("Enter the number:");
		//BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		//String tempNum=br.readLine();
		
		InsertionSort isort=new InsertionSort();
		isort.insertionSort();
	}
}
