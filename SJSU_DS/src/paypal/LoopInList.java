package paypal;

public class LoopInList {
	
	private static Node head;

	public static void main(String[] args) {
		append(new Node(2));
		Node cycle = new Node(3);
		append(cycle);
		append(new Node(4));
		append(new Node(5));
		append(cycle);
		//display();
		
		System.out.println(isCyclic());
		
	}
	
	private static String isCyclic() {
		
		if(null == head)
			return "Not Cyclic";
		
		Node slow = head;
		Node fast = head;
				
		while(fast!=null && fast.getNext()!=null)
		{
			slow = slow.getNext();
			fast = fast.getNext().getNext();
			
			if(slow==fast)
			{
				return "Cyclic";
			}
		}
					
		return null;
	}

	private static void append(Node newNode)
	{
		if(null == head)
		{
			head = newNode;
		}
		else
		{
			Node temp = head;
			while(temp.getNext()!=null)
			{
				temp = temp.getNext();
			}
			temp.setNext(newNode);
		}
	}
	
	private static void display()
	{
		Node temp = head;
		do
		{
			System.out.println(temp.getData()+"->");
			temp = temp.getNext();
		}while(temp!=null);
	}
	
	private static class Node{
		private int data;
		private Node next;
		
		Node(int data)
		{
			this.data = data;
			this.next = null;
		}

		public int getData() {
			return data;
		}

		public void setData(int data) {
			this.data = data;
		}

		public Node getNext() {
			return next;
		}

		public void setNext(Node next) {
			this.next = next;
		}
	}

}
