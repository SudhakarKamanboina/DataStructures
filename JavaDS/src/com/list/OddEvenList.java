package com.list;

public class OddEvenList {

	dataNode firstNode;
	
	public void addNode(int data)
	{
		dataNode number = new dataNode(data);
			if(firstNode==null)
			{
				firstNode=number;
			}
			else
			{
				dataNode temp=firstNode;
				
				while(temp.next!=null)
				{
					temp=temp.next;
				}
				temp.next=number;
			}
	}
	
	public void rearrange()
	{
		dataNode even=null; 
		
		if(firstNode==null || firstNode.next==null || firstNode.next.next==null)
		{
			return;
		}
		dataNode temp;
		dataNode odd= firstNode;
		
		while(odd!=null && odd.next!=null)
		{
			temp=odd.next.next;
			odd.next.next=even;
			
			even = odd.next;
			odd.next=temp;
			
			if(temp!=null)
				odd=temp;
		}
		odd.next=even;
	}
	
	public void printList()
	{
		dataNode temp=firstNode;
		
		while(temp!=null)
		{
			System.out.print(" " +temp.data);	
			temp=temp.next;
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
			
		OddEvenList list= new OddEvenList();
		list.addNode(1);
		list.addNode(2);
		list.addNode(3);
		list.addNode(4);
		list.addNode(5);
		list.addNode(6);
		
		list.rearrange();
		list.printList();
		
	}

}

class dataNode {
	
	int data;
	dataNode next;
	
	public dataNode()
	{
		
	}
	
	public dataNode(int data)
	{
		this.data=data;
	}
}


