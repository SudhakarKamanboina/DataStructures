package linkedlist;

public class LinkedList 
{
    	
	private Node start;

        public void insert(int x)
		{
             if(start==null)
				start=new Node(x,start);
				
             if(start!=null)
			 {
					Node temp=start;
					while(temp.next!=null)
					{
						temp=temp.next;
					}
					temp.next=new Node(x);
			}
		}

		public void display()
		{
			if(start==null)
			{
               System.out.println("List is empty!");
			}
			else
			{
				Node temp=start;

					while(temp.next!=null)
					{
						temp=temp.next;
						System.out.println(temp.getData());
					}
			}
		}


		public void delete(int x)
		{    
			Node prev=start;
			Node temp=start;
			while(temp.getData()!=x)
			{
				if(temp.next==null)
				{
					System.out.println("Element not found!!");
					break;
				}
				prev=temp;
				temp=temp.next;
			}
			if(temp==start)
			{
				start=start.next;
			}
			else
			{
				prev.next=temp.next;
			}
		}


		private static class Node
		{
			private int data;
			Node next;
			Node(int data)
			{
				this.setData(data);
			}
			Node(int data,Node next)
			{
				this.setData(data);
				this.next=next;
			}
			
			public int getData() 
			{
				return data;
			}
			
			public void setData(int data) 
			{
				this.data = data;
			}
		}
	}
