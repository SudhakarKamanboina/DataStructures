package linkedlist;
import linkedlist.LinkedList;

	public class MainClass extends LinkedList
	{
		public static void main(String args[])
		{
			System.out.println("list");
			LinkedList l=new LinkedList();
			l.insert(1);
			l.insert(2);
			l.insert(3);
			l.insert(4);
			l.insert(5);
			l.display();
			System.out.println("-------------------------");
			l.delete(2);
			System.out.println("---------after deletion---------");
			l.display();
		}
	}