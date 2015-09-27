package com.list;

import java.awt.HeadlessException;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Link {

	public int data;
	public Link next;
	
	Link(int data)
	{
		this.data=data;
	}
	
	public void display()
	{
		System.out.println("data :" + data);
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		
		LinkList linkList=new LinkList();
		
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
		case 2: linkList.displayList();
				break;
		case 3: linkList.insertAtLast();
				break;
		case 4: linkList.insertInBetween();
				break;
		case 5: linkList.removeFirst();
				break;
		case 6: linkList.removeLast();
				break;
		case 7: linkList.removeInbetween();
				break;
		case 8: linkList.removeValue();
				break;
		case 9: linkList.reverseList();
				break;
		case 10: System.exit(0);
		}
		
		}
	}

}

class LinkList {
	
	public Link firstLink;
	
	LinkList()
	{
		firstLink=null;
	}
	
	public boolean isEmpty()
	{
		return(firstLink==null);
	}
	
	public void insertAtFirst()
	{
		int data=0;
		try{
			System.out.println("Enter the data :");
			BufferedReader dataReader = new BufferedReader(new InputStreamReader(System.in));
			data=Integer.parseInt(dataReader.readLine());
			System.out.println("Data added to linkedlist");
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		Link newLink= new Link(data);
		if(isEmpty())
		{
			firstLink=newLink;
		}
		else{
		newLink.next=firstLink;
		firstLink=newLink;
		}
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
			System.out.println("Data added to linkedlist");
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		Link newLink= new Link(data);
		Link temp=firstLink, previous=firstLink;
		int count=0;
		while(temp!=null)
		{
			count++;
			if(position==count)
			{
				previous.next=newLink;
				newLink.next=temp;
			}
			previous=temp;
			temp=temp.next;
		}
	}
	
	public void removeFirst()
	{
		Link temp;
		
		temp=firstLink;
		if(temp.next==null)
		{
			firstLink=null;
		}
		else
		{
			temp.next=temp.next.next;
		}
		System.out.println("first element is deleted");
	}
	
	public void removeInbetween()
	{
		int position=0;
		try
		{
			System.out.println("Enter the position :");
			BufferedReader dataReader = new BufferedReader(new InputStreamReader(System.in));
			position=Integer.parseInt(dataReader.readLine());

		}catch(Exception e)
		{
			e.printStackTrace();
		}
		Link temp=firstLink, previous=firstLink;
		while(temp!=null)
		{
			position--;
			if(position==0)
			{
				previous.next=temp.next;
			}
			previous=temp;
			temp=temp.next;
		}
		System.out.println("Data deleted.");
	}
	
	public void insertAtLast()
	{
		int data=0;
		try{
			System.out.println("Enter the data :");
			BufferedReader dataReader = new BufferedReader(new InputStreamReader(System.in));
			data=Integer.parseInt(dataReader.readLine());
			System.out.println("Data added to linkedlist");
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		Link newLink= new Link(data);
		if(isEmpty())
		{
			firstLink=newLink;
		}
		else{
			Link temp= firstLink;
			
			while(temp.next!=null)
			{	
				temp=temp.next;
			}
			temp.next=newLink;
		}
	}
	
	public void removeLast()
	{
		Link temp= firstLink;
		
		if(temp.next==null)
		{
			firstLink=null;
		}
		while(temp.next!=null)
		{
			temp=temp.next;
		}
	}
	
	public void displayList()
	{
		Link temp;
		
		temp= firstLink;
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
	
	public void sortList()
	{
		Link temp,previous;
		
		for(temp=firstLink;temp!=null;temp=temp.next)
		{
			for(previous=firstLink;previous!=null;previous=previous.next)
			{
					if(temp.data < previous.data)
					{
						
					}
			}
		}
		
	}
	
	public void removeValue()
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
		
		Link temp=firstLink;
		
		if(firstLink.data==data)
		{
			firstLink=temp.next;
		}
		else
		{
		while(temp.next.data!=data)
		{
			temp=temp.next;
		}
		temp.next=temp.next.next;
		}
		System.out.println(" Node deleted");
	}
	
	public void reverseList()
	{
		Link previous,temp, next;
		
		
		previous=null;
		temp=firstLink;
		next=null;
		
		while(temp!=null)
		{
			next=temp.next;
			temp.next=previous;
			previous=temp;
			temp=next;
		}
		firstLink=previous;
	}
	
	public void searchNode()
	{
		
	}
}
