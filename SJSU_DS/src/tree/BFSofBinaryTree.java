package tree;

import java.util.Scanner;

public class BFSofBinaryTree
{
    private BinaryTreeNode root;
    
    public static void main(String[] args)
    {
        BFSofBinaryTree bt = new BFSofBinaryTree();
        Scanner scan = new Scanner(System.in);
        char ch;
        int choice;
        do
        {
            System.out.println("1. Insert Element ");
            //System.out.println("2. Y to continue || N to exit");
            
            choice = scan.nextInt();
            
            switch(choice)
            {
                case 1: System.out.println("Enter integer element to insert");
                bt.insert( scan.nextInt() );                     
                break;
            }
            
            System.out.println("\nDo you want to continue (Type y or n) \n");
            ch = scan.next().charAt(0);
        }while(ch == 'Y'|| ch == 'y');
    }
    
    void insert(int val)
    {
        if(root == null)
        {
            root = new BinaryTreeNode(val);
        }
        else
        {
            
        }
    }
    

}

class BinaryTreeNode
{
    private int data;
    private BinaryTreeNode left;
    private BinaryTreeNode right;
    
    BinaryTreeNode(int d)
    {
        this.data = d;
    }
    
    public int getData()
    {
        return data;
    }
    public void setData(int data)
    {
        this.data = data;
    }
    public BinaryTreeNode getLeft()
    {
        return left;
    }
    public void setLeft(BinaryTreeNode left)
    {
        this.left = left;
    }
    public BinaryTreeNode getRight()
    {
        return right;
    }
    public void setRight(BinaryTreeNode right)
    {
        this.right = right;
    }
    
    
    
}
