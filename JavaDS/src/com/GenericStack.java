package com;

public class GenericStack<T extends Object> {

	private int stackSize;
	private T[] stackArr;
	private int top;
	
	
	public GenericStack()
	{
		stackSize=100;
		stackArr=(T[]) new Object[stackSize];
		top=-1;
	}
	
	public boolean isStackFull()
	{
		return (top==stackSize-1);
	}

	public boolean isStackEmpty()
	{
		return (top==-1);
	}
	
	public void push(T entry)
	{
		if(isStackFull())
		{
			System.out.println("STACK IS FULL");
		}
		else
		{
			stackArr[++top]=entry;
		//	System.out.println(" Element "+ entry + "added to the stack.");
		}
	}
	
	public T pop() throws Exception
	{
		T entry;
		if(isStackEmpty())
		{
			throw new Exception("No element in stack.");
		}
		
		entry = stackArr[top--];
		return entry;
	}
	
}
