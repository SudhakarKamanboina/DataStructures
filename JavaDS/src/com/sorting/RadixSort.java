package com.sorting;

import java.util.LinkedList;
import java.util.Queue;

public class RadixSort {

	Queue[] buckets = new Queue[10]; 
	
	public RadixSort()
	{		
		for(int i=0;i<10;i++)
		{
			buckets[i]= new LinkedList();
		}
	}
	
	public void getRadixSort(int[] data)
	{
		boolean flag=true;
		int divisor=1;
		
		while(flag)
		{
			flag=false;
			
			// put elements into buckets
			for(int i=0;i<data.length;i++)
			{
					int hashIndex=(data[i]/divisor) %10;
					if(hashIndex > 0 ) flag=true;
					
					buckets[hashIndex].add(new Integer (data[i]));
			}
			divisor=divisor*10;
			int i=0;
			// retrieve elements from queue and put back in array maintaining order from queue
			for(int j=0;j<10;j++)
			{
				while(!buckets[j].isEmpty())
				{
					Integer temp= (Integer)buckets[j].poll();
					data[i]=temp.intValue();
					i++;
				}
			}		
		}		
	}
	public static void main(String[] args)
	{
		int[] data={10,5,36,38,999999,179,139};
		RadixSort rSort = new RadixSort();
		
		rSort.getRadixSort(data);
		
		for(int k=0;k<data.length;k++)
		{
			System.out.print("  "+data[k]);
		}
	}
}
