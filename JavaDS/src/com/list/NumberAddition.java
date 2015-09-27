package com.list;

public class NumberAddition {
	

	Node firstdigit;
	int carry;
	
	public boolean isEmpty()
	{
		return(firstdigit==null);
	}
	
	public void addNode(int data)
	{
		Node digit = new Node(data);
			if(firstdigit==null)
			{
				firstdigit=digit;
			}
			else
			{
				Node temp=firstdigit;
				
				while(temp.next!=null)
				{
					temp=temp.next;
				}
				temp.next=digit;
			}
	}
	
	public void addNode(Node digit)
	{
			if(isEmpty())
			{
				firstdigit=digit;
			}
			else
			{
				digit.next=firstdigit;
				firstdigit=digit;
			}
	}
	
	public void display()
	{
		Node temp=firstdigit;
		
		while(temp!=null)
		{
			System.out.print(" " +temp.data);	
			temp=temp.next;
		}
	}
	
	public int getLength()
	{
		int count=0;
		Node temp=firstdigit;
		
		while(temp!=null)
		{
			temp=temp.next;
			count++;
		}
		return count;
	}
	
	public void addNumbers(NumberAddition number1,NumberAddition number2)
	{
		NumberAddition result;
		//Integer carry= new Integer(0);
		int state =  number1.getLength()- number2.getLength();
		
		addNode(addTwo(number1.firstdigit,number2.firstdigit,state,this.carry));
		if(this.carry > 0)
		{
			Node temp = new Node(carry);
			temp.next=firstdigit;
			firstdigit=temp;
		}
	}
	
	public Node addTwo(Node number1, Node number2,int state ,int carry)
	{
		if(number1==null && number2==null)
		{
			return null;
		}
		
		Node result = new Node();		
		if(state > 0)
		{
			result.next=addTwo(number1.next,number2,state-1,this.carry);
			result.data=number1.data + this.carry;
		}
		
		else if(state < 0)
		{
			result.next=addTwo(number1,number2.next,state+1,this.carry);
			result.data=number2.data + this.carry;
		}
		else{
			result.next=addTwo(number1.next,number2.next,0,this.carry);
			result.data= number1.data + number2.data + this.carry;
		}
		
		this.carry= (result.data)/10;
		result.data %=10;
		
		return result;
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
			
		NumberAddition number1 = new NumberAddition();
		number1.addNode(1);
		number1.addNode(2);
		number1.addNode(6);
		System.out.println("First Number is : ");
		number1.display();
		System.out.println();
		
		NumberAddition number2 = new NumberAddition();
		number2.addNode(9);
		number2.addNode(5);
		number2.addNode(6);
		System.out.println("Second Number is : ");
		number2.display();
		System.out.println();
		
		NumberAddition addition = new NumberAddition();
		addition.addNumbers(number1,number2);
		System.out.println("Addition is : ");
		addition.display();
	}

}

class Node {
	
	int data;
	Node next;
	
	public Node() {
		
	}
	
	public Node(int data)
	{
		this.data=data;
	}
	
	
}