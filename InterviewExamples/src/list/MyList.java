package list;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.omg.CORBA.FREE_MEM;

public class MyList
{
    //Author : Sudhakar
    public static Node start=null;
    
    public static void main(String arg[])
    {
        System.out.println("Linked List \n");
        System.out.println("1. create \n");
        System.out.println("2. Insert element \n");
        System.out.println("3. reverse without new node \n");
        System.out.println("4. reverse with new node \n");
        System.out.println("5: Delete element \n");
        System.out.println("6. exit \n");
        String input=null,point=null;
        
        try
        {
            BufferedReader bd = new BufferedReader(new InputStreamReader(System.in));
            input=bd.readLine();
            
            switch(Integer.parseInt(input))
            {
                case 1: System.out.println("Enter no. of elements \n");
                        String elements = bd.readLine();
                        for(int i=0;i<new Integer(elements);i++)
                        {
                            System.out.println("enter element \n");
                            int d = Integer.parseInt(bd.readLine());
                            create(d);
                        }
                        display(start);
                        break;
                case 2: System.out.println("1. Insert elemnt at start \n");
                        System.out.println("2. Insert elemnt at end \n");
                        System.out.println("3. Insert elemnt randomly \n");
                        input=bd.readLine();
                        switch(Integer.parseInt(input))
                        {
                            case 1: System.out.println("please the enter the element :\n");
                                    input=bd.readLine();
                                    addAtStart(Integer.parseInt(input));
                                    break;
                            case 2: System.out.println("please the enter the element :\n");
                                    input=bd.readLine();
                                    addAtEnd(Integer.parseInt(input));
                                    break;
                            case 3: System.out.println("Enter the element after which u want ur element to be added \n");
                                    point = bd.readLine();
                                    System.out.println("Enter ur new element \n");
                                    input=bd.readLine();
                                    addElementRandomly(Integer.parseInt(point),Integer.parseInt(input));
                                    break;
                            default:System.out.println("Invalid input");
                                    break;
                        }
                        
                        break;
                case 3: reverseWithoutNewNode();
                        break;
                case 4: reverseWithNewNode();
                        break;
                case 5: 
                    
                    
                case 6: System.exit(0);
                default: System.out.println("Invalid input");
                         break;
            }
            main(null);
            
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
        
    }
    
    
    private static void addElementRandomly(int point, int input)
    {
        Node temp=start, prev=null,temp1=null;
        do
        {
            prev = temp;
            temp = temp.next;
        }while(prev.getData() != point);
        
        temp1 = new Node(input);
        temp1.next = temp;
        prev.next = temp1;
        display(start);
    }


    private static void addAtEnd(int parseInt)
    {
        Node head=start;
        for(;head.next!=null;head=head.next);
        head.next = new Node(parseInt);
        display(start);
    }


    private static void addAtStart(int data)
    {
        Node temp = null,head=start;
        
        temp = new Node(data);
        temp.next = head;
        head = temp;
        
        display(head);
        
    }


    private static void reverseWithNewNode()
    {
        Node head2=null, temp=start, temp1=null;
        
        while(temp!=null)
        {
            if(head2 == null)
            {
                temp1 = new Node(temp.getData());
                head2 = temp1;
                head2.next = null;
            }
            else
            {
                temp1 = new Node(temp.getData());
                temp1.next = head2;
                head2 = temp1;
            }
            temp = temp.next;
        }
        display(head2);
        
    }


    public static void create(int data)
    {
        Node temp, temp1;
        
        if (start==null)
        {
            start = new Node(data);
        }
        else
        {
            temp =start;
            while(temp.next != null)
            {
                temp = temp.next;
            }
            temp1=new Node(data);
            temp1.next=null;
            temp.next = temp1;
        }
    }
    
    public static void display(Node param)
    {
        Node temp = param;
        if (param ==null)
            System.out.println("Empty List");
        else
        {
            while (temp.next !=null)
            {
                System.out.println(temp.getData());
                temp=temp.next;
                
                
            }
            System.out.println(temp.getData());
        }
    }
    
    public static void reverseWithoutNewNode()
    {
        Node head2=null,prev=start,ptr;
        
        while (start.next != null)
        {
            ptr= start;   
            while(ptr.next !=null)
                {
                    prev = ptr;
                    ptr=ptr.next;
                }
                if(head2 == null)
                {
                    head2 = ptr;
                }
                else
                {
                    ptr.next = prev;
                    prev.next = null;
                }
        }
        display(head2);
    }
    
}

class Node
{
    private int data;
    Node next=null;
    
    Node (int d)
    {
        this.data = d;
    }
    
    public void setData(int d)
    {
        this.data = d;
    }
    
    public int getData()
    {
        return this.data;
    }
    
}