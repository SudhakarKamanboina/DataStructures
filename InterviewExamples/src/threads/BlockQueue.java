package threads;

import java.util.LinkedList;
import java.util.List;


public class BlockQueue 
{
    public static void main(String arg[])
    {
        BlockingQueue q = new BlockingQueue(10);
        consumer c1 = new consumer(q);
        producer p1 = new producer(q);
        
        Thread t1 = new Thread(c1);
        Thread t2 = new Thread(p1);
        
        t2.start();
        t1.start();
    }
}

class consumer implements Runnable
{
    BlockingQueue q;
    public consumer (BlockingQueue q1)
    {
        this.q = q1;
    }
    
    public void run() 
    {
        while(true)
        {
            Object temp = q.dequeue();
            System.out.println("removed "+temp.toString());
        }
    }
    
}

class producer implements Runnable
{
    BlockingQueue q;
    producer (BlockingQueue q1)
    {
        this.q = q1;
    }
    
    public void run() 
    {
        int i=0;
        while(i<20)
        {
            System.out.println("added "+i);
            q.enqueue(i++);
        }
    }
    
}



class BlockingQueue
{
    private List<Object> Queue = new LinkedList<Object>();
    private int limit =10;
    
    public BlockingQueue(int limit1)
    {
        this.limit = limit1;
    }

    public synchronized void enqueue (Object input)
    {
        while(Queue.size() == limit)
        {
            try 
            {
                wait();
            }
            catch (InterruptedException e)
            {
                e.printStackTrace();
            }
        }
        if(Queue.size() ==  0)
        {
            notify();
        }
        
        Queue.add(input);
    }
    
    public synchronized Object dequeue ()
    {
        while(Queue.size() == 0)
        {
            try 
            {
                wait();
            }
            catch (InterruptedException e)
            {
                e.printStackTrace();
            }
        }
        if(Queue.size() == limit)
        {
            notify();
        }
        
        return Queue.remove(0);
    }
}


