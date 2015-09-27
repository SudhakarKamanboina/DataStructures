package com.list;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class DoublyLinkedList {

	DNode newNode;
	
	public boolean isEmpty()
	{
		return (newNode==null);
	}
	
	public void insertAtFirst()
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
		
		DNode node = new DNode(data);
		if(isEmpty())
		{
			newNode=node;
		}
		else
		{
			node.next=newNode;
			newNode.previous=node;
			newNode=node;
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
		DNode node = new DNode(data);
		
		DNode temp = newNode;
		
		while(temp.next!=null)
		{
			temp=temp.next;
		}
		
		temp.next=node;
		node.previous=temp;
	}
	
	public void display()
	{
		DNode temp;
		
		temp= newNode;
		if(temp==null)
		{
			System.out.println("LinkedList is empty");
			return;
		} 	
		while(temp!=null)
		{
			System.out.print("  "+ temp.data);
			temp=temp.next;
		}		
		System.out.println("");
	}
	
	public void insertInBetween()
	{
		int data=0,position=0;
		try{
			System.out.println("Enter the position where you want to enter the data:");
			BufferedReader dataReader = new BufferedReader(new InputStreamReader(System.in));
			position=Integer.parseInt(dataReader.readLine());
			System.out.println("Enter the data :");
			dataReader = new BufferedReader(new InputStreamReader(System.in));
			data=Integer.parseInt(dataReader.readLine());
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		
		DNode node = new DNode(data);
		DNode temp = newNode, previous=null;
		int count=0;
		
		while(temp!=null)
		{
			count ++;
			if(count==position)
			{
				node.next=temp;
				temp.previous=node;
				previous.next=node;
				node.previous=previous;
				break;
			}
			previous=temp;
			temp=temp.next;
		}
	}
	
	public void removeFirst()
	{
		DNode temp;
		
		if(isEmpty())
		{
			System.out.println("List is empty");
		}
		
		temp= newNode;
		
		newNode=temp.next;
		temp.next=null;
		newNode.previous=null;
		
		System.out.println("first node deleted");
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		
		DoublyLinkedList linkList = new DoublyLinkedList();
		
		while(true)
		{
		System.out.println("------LINKED LIST-------");
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
		case 1: linkList.insertAtFirst();
				break;
		case 2: linkList.display();
				break;
		case 3: linkList.insertAtLast();
				break;
		case 4: linkList.insertInBetween();
				break;
		case 5: linkList.removeFirst();
				break;
//		case 6: linkList.removeLast();
//				break;
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

class DNode{
	
	int data;
	DNode previous;
	DNode next;
	
	public DNode(int data)
	{
		this.data=data;
	}
}