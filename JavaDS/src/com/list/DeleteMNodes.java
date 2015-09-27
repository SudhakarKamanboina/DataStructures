package com.list;

public class DeleteMNodes {

	Node1 firstNode;
	
	public void addNode(int data)
	{
		Node1 number = new Node1(data);
			if(firstNode==null)
			{
				firstNode=number;
			}
			else
			{
				Node1 temp=firstNode;
				
				while(temp.next!=null)
				{
					temp=temp.next;
				}
				temp.next=number;
			}
	}
	
	
	public void deleteNodes(int m, int n)
	{
		Node1 temp = firstNode, deleteTemp=null;
		int count=1;
		boolean deleteNode=false;
		
		if(temp==null)
		{
			return;
		}
		
		/*
		while(temp!=null)
		{
			if(count==m && !deleteNode)
			{
				deleteNode=true;
				deleteTemp=temp.next;
				count=0;
			}
			else if(deleteNode && count!=n && deleteTemp.next!=null)
			{
					deleteTemp=deleteTemp.next;
					if(deleteTemp.next==null)
					{
						temp.next=null;
						break;
					}
					count++;
			}
			else if(deleteNode && count==n)
			{
				 temp.next=deleteTemp;
				 deleteNode=false;
				 count=0;
			}
			else
			{
				temp=temp.next;
				count++;
			}
		}*/
		
		while(temp!=null)
		{
			for(int i=1;i<m && temp!=null;i++)
			{
				temp=temp.next;
			}
			
			if(temp==null)
			{
				return;
			}
			
			deleteTemp = temp.next;
			
			for(int j=1;j<=n && deleteTemp!=null;j++)
			{
				deleteTemp=deleteTemp.next;
			}
			temp.next=deleteTemp;
			temp=deleteTemp;
		}
	}
	
	public void printList()
	{
		Node1 temp=firstNode;
		
		while(temp!=null)
		{
			System.out.print(" " +temp.data);	
			temp=temp.next;
		}
	}
		
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		DeleteMNodes deleteMNodes = new DeleteMNodes();
		
		deleteMNodes.addNode(1);
		deleteMNodes.addNode(2);
		deleteMNodes.addNode(3);
		deleteMNodes.addNode(4);
		deleteMNodes.addNode(5);
		//deleteMNodes.addNode(6);
		//deleteMNodes.addNode(7);
		//deleteMNodes.addNode(8);
		
		deleteMNodes.deleteNodes(2, 2);
		deleteMNodes.printList();
	}

}

class Node1
{
	int data;
	Node1 next;
	
	public Node1(int data)
	{
		this.data=data;
	}
}