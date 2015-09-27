package linkedlist;

import java.util.Scanner;

public class ListOps
{

    private Node head;
    
    private int length;
    
    /**
     * @param args
     */
    public static void main(String[] args)
    {
        int data;
        int ch;
        ListOps obj = new ListOps();
        
        while(true)
        {
            System.out.println("\n 1. Create \n 2. Insert \n 3. Display \n 4. Exit \n");
            Scanner in = new Scanner(System.in);
            ch = in.nextInt();
            switch(ch)
                {
                    case 1:
                        System.out.println("\n Enter the element: ");
                        data = in.nextInt();
                        obj.createList(data);
                        break;
                        
                    case 3:
                        obj.display();
                    case 4:
                        System.exit(0);
                }
        }
    }

    private void display()
    {
        Node temp = head;
        while(temp != null)
        {
            System.out.println(temp.getData());
            temp = temp.getNext();
        }
    }

    private void createList(int data)
    {
        Node newNode = new Node(data);
        Node temp = head;
        if(head == null)
            head = newNode;
        else
        {
            while(temp.getNext() != null)
            {
                temp = temp.getNext();
            }
            temp.setNext(newNode);
        }
    }

}
