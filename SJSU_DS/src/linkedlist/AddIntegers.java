package linkedlist;

import java.util.List;

public class AddIntegers {

	
	/*
	 * Add two numbers represented by linked lists | Set 1
Given two numbers represented by two lists, write a function that returns sum list. The sum list is list representation of addition of two input numbers.

Example 1

Input:
  First List: 5->6->3  // represents number 365
  Second List: 8->4->2 //  represents number 248
Output
  Resultant list: 3->1->6  // represents number 613
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Node first = new Node(1);
		//Node temp = new Node(2);
		//Node temp2 = new Node(3);
		//temp.setNext(temp2);
		//first.setNext(temp);
		
		Node second = new Node(4);
		Node five = new Node(5);
		Node six = new Node(6);
		five.setNext(six);
		second.setNext(five);
		
		Node res = addTwoLists(first, second);
		while(res!=null)
		{
			System.out.println(res.getData()+">");
			res = res.getNext();
		}
	}
	
	
	/* Adds contents of two linked lists and return the head node of resultant list */
	static Node addTwoLists (Node first, Node second)
	{
		Node res=null; // res is head node of the resultant list
		Node temp=null, prev=null;
	    int carry = 0, sum, i=0;
	 
	    while (first != null || second != null) //while both lists exist
	    {
	        // Calculate value of next digit in resultant list. 
	        // The next digit is sum of following things
	        // (i)  Carry
	        // (ii) Next digit of first list (if there is a next digit)
	        // (ii) Next digit of second list (if there is a next digit)
	        sum = carry + (first != null ? first.getData(): 0) + (second != null ? second.getData(): 0);
	 
	        // update carry for next calulation
	        carry = (sum >= 10)? 1 : 0;
	 
	        // update sum if it is greater than 10
	        sum = sum % 10;
	 
	        // Create a new node with sum as data
	        temp = new Node(sum);
	 
	        // if this is the first node then set it as head of the resultant list
	        if(res == null)
	            res = temp;
	        else // If this is not the first node then connect it to the rest.
	            prev.setNext(temp);
	 
	        // Set prev for next insertion
	        prev  = temp;
	 
	        // Move first and second pointers to next nodes
	         if(first != null) first = first.getNext();
	         if(second != null) second = second.getNext();
	    }
	 
	    if (carry > 0)
	      temp.setNext(new Node(carry));
	 
	    // return head of the resultant list
	    return res;
	}

}
	

