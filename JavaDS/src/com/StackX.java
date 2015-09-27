package com;

public class StackX {
		
	
	int maxsize=10;
	  int top;
	  int[] StackArray;
	  
	  StackX()
	  {
	     StackArray=new int[maxsize];
		 top=-1;
	  }
	  
	  public boolean isEmpty()
	  {
	      return(top==-1);
	  }
	  public boolean isFull()
	  {
		  return(top==maxsize);	
	  }

	  public void push(int item)
	  {
	    if(isFull())
		{
		  System.out.println("Stack is full");
		}
	    top++;
		StackArray[top]=item;
	  }
	  
	  public int pop()
	  {
	    if(isEmpty())
		{	
		  System.out.println("Can not delete elemement. Stack is Empty");
		  return 0;
		}
	     int pop=StackArray[top];
		 top--;
		 return pop;
	  }
	  
	  public void display()
	  {
		  int temp=top;
		  System.out.println("");
		  while(temp!=-1)
		  {
			  System.out.print(" " + StackArray[temp]);
			  temp--;
		  }
	  }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		StackX stack= new StackX();
		stack.push(10);
		stack.push(20);
		stack.push(30);
		stack.display();
		
		stack.pop();
		stack.display();
	}

}
