package com.list;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CircularList {

	CircularNode firstNode;
	
	public boolean isEmpty()
	{
		return (firstNode==null);
	}
	
	public void insertAtFront()
	{
		int data=0;
		try{
			System.out.println("Enter the data :");
			BufferedReader dataReader = new BufferedReader(new InputStreamReader(System.in));
			data=Integer.parseInt(dataReader.readLine());
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		CircularNode node = new CircularNode(data);
		node.next=node;
		if(isEmpty()){
			firstNode=node;
		}
		else{
			CircularNode temp;
			temp=firstNode;
			
			while(temp.next!=firstNode){
				temp=temp.next;
			}
			node.next=firstNode;
			temp.next=node;
			firstNode=node;
		}
	}
	
	public void display()
	{
		if(isEmpty()){
			System.out.println("LIST IS EMPTY");
		}
		else{
			CircularNode temp = firstNode;
			
			while(temp!=null)
			{
				System.out.print("  "+temp.data);
				temp=temp.next;
				if(temp==firstNode){
					break;
				}
			}
		}
	}
	
	public void insertAtLast()
	{
		int data=0;
		try{
			System.out.println("Enter the data :");
			BufferedReader dataReader = new BufferedReader(new InputStreamReader(System.in));
			data=Integer.parseInt(dataReader.readLine());
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		CircularNode node = new CircularNode(data);
		node.next=node;
		if(isEmpty()){
			firstNode=node;
		}
		else{
			CircularNode temp= firstNode;
			while(temp!=null)
			{
				temp=temp.next;
				if(temp.next==firstNode){
					break;
				}
			}
			temp.next=node;
			node.next=firstNode;
		}
	}
	
	public void removeFirst()
	{
		if(isEmpty())
		{
			System.out.println("LIST IS EMPTY");
		}
		else
		{
			CircularNode temp = firstNode;
			
			while(temp!=null)
			{
				temp=temp.next;
				if(temp.next==firstNode){
					break;
				}					
			}
			temp.next=firstNode.next;
			firstNode=null;
			firstNode=temp.next;
		}
	}
	
	public void removeLast()
	{
		if(isEmpty())
		{
			System.out.println("LIST IS EMPTY");
		}
		else
		{
			CircularNode temp = firstNode;
			while(temp!=null)
			{
				temp=temp.next;
				if(temp.next.next==firstNode)
				{
					break;
				}
			}
			CircularNode dNode = temp.next.next;
			temp.next=firstNode;
			dNode=null;
		}
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException{
		
		CircularList cList = new CircularList();
		
		while(true)
		{
		System.out.println("------CIRCULAR LINKED LIST-------");
		System.out.println("1. Insert at first");
		System.out.println("2. Display");
		System.out.println("3. Insert at last");
		System.out.println("4. Insert inBetween");
		System.out.println("5. Remove first");
		System.out.println("6. Remove last");
		System.out.println("7. Remove inBetween");
		System.out.println("8. Remove by value");
		System.out.println("9. Reverse linkedlist");
		System.out.println("9. sort list");
		System.out.println("10. Exit");
		System.out.println("Enter your choice");
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in)); 
		
		switch(Integer.parseInt(reader.readLine()))
		{
		case 1: cList.insertAtFront();
				break;
		case 2: cList.display();
				break;
		case 3: cList.insertAtLast();
				break;
		case 4: //cList.insertInBetween();
				break;
		case 5: cList.removeFirst();
				break;
		case 6: cList.removeLast();
				break;
//		case 7: linkList.removeInbetween();
//				break;
//		case 8: linkList.removeValue();
//				break;
//		case 9: linkList.reverseList();
//				break;
		case 10: System.exit(0);
		}	
		}

	}
}

class CircularNode
{
	int data;
	CircularNode next;
	
	public CircularNode(int data)
	{
		this.data =data;
	}
}
