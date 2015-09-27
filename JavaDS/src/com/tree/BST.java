package com.tree;

import com.GenericStack;


public class BST {

	Node root;
	GenericStack<Node> nodeStack;
	
	public BST()
	{
		
	}
	
	public void insert(int data)
	{
		Node newNode= new Node(data);
		Node current=root;
		
		while(true)
		{
			if(root==null)
			{
				root=newNode;
				System.out.println("root added "+ newNode.data);
				break;
			}
			if(newNode.data < current.data)
			{
				if(current.left==null)
				{
					current.left=newNode;
					System.out.println("Left child added "+ newNode.data+" to "+ current.data);
					break;
				}
				current=current.left;
			}
			if(newNode.data > current.data)
			{
				if(current.right==null)
				{
					current.right=newNode;
					System.out.println("Right child added "+ newNode.data +" to " + current.data);
					break;
				}
				current=current.right;
			}
		}
	}

	public void inorder(Node localRoot)
	{
		if(localRoot!=null)
		{
			inorder(localRoot.left);
			System.out.print("  "+localRoot.data);
			inorder(localRoot.right);
		}
	}
	
	public void displayInorder()
	{
		System.out.println(" ");
		inorder(root);
	}
	
	public void inorderIterative() throws Exception
	{
		nodeStack= new GenericStack<Node>();
		Node temp=root;
		boolean isEmpty = false;
		
		while(!isEmpty)
		{
			if(temp!=null)
			{
				nodeStack.push(temp);
				temp=temp.left;
			}
			else
			{
				if(nodeStack.isStackEmpty())
				{
					isEmpty=true;
				}
				else
				{
					temp=nodeStack.pop();
					System.out.println("  "+temp.data );
					temp=temp.right;
				}
			}
		}
	}
	
	public void preOrderIterative() throws Exception
	{
		nodeStack= new GenericStack<Node>();
		Node temp =root;
		nodeStack.push(temp);
		
		while(!nodeStack.isStackEmpty())
		{
			temp= nodeStack.pop();
			System.out.print("  "+ temp.data);

			if(temp.right!=null)
				nodeStack.push(temp.right);
			if(temp.left!=null)
				nodeStack.push(temp.left);
		}
	}
	
	public void postOrderIterative() throws Exception
	{
		nodeStack= new GenericStack<Node>();
		GenericStack<Node> outputStack = new GenericStack<Node>();
		
		Node temp = root;
		nodeStack.push(temp);
		
		while(!nodeStack.isStackEmpty())
		{
			temp= nodeStack.pop();
			outputStack.push(temp);
			
			if(temp.left!=null)
			{
				Node current=temp.left;
				nodeStack.push(current);
			}
			if(temp.right!=null)
			{
				Node current=temp.right;
				nodeStack.push(current);
			}
		}
		while(!outputStack.isStackEmpty())
		{
			Node current = outputStack.pop();
			System.out.print("  "+ current.data);
		}
	}
	
	public void heightTree()
	{
		Node temp = root;
		System.out.println(" height of tree is :"+findTreeHeight(temp));
	}

	public int findTreeHeight(Node root)
	{
		if(root==null)
		{
			return 0;
		}
		return(Math.max(findTreeHeight(root.left), findTreeHeight(root.right))+1);
	}
	
	public void searchData()
	{
		Node temp= root;
		System.out.println(" Is required data found : "+ searchBST(temp, 30));
	}
	
	public boolean searchBST(Node temp,int data)
	{
		if(temp == null)
			return false;
		if(temp.data == data )
			return true;
		
		if( temp.data < data)
		return	searchBST(temp.right,data);
		else
		return	searchBST(temp.left,data);
		//return false;
	}

	public static void main(String[] args)
	{
			BST tree=new BST();
			tree.insert(10);
			tree.insert(5);
			tree.insert(30);
			tree.insert(2);
			tree.insert(7);
			//tree.displayInorder();
			
			System.out.println();
			//System.out.println("Inorder iterative traversal ");
			
			try{
				//tree.inorderIterative();
					//tree.preOrderIterative();
				//tree.postOrderIterative();
				//tree.heightTree();
				tree.searchData();
			}catch(Exception e)
			{
				System.out.println("System Error "+e.getMessage());
			}
			
	}
}

class Node 
{
	int data;
	Node left;
	Node right;
	
	Node(int data)
	{
		this.data=data;
	}
}