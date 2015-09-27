package threads;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class BlockQueueUsingAPI
{
    public static void main(String arg[])
    {
        BlockingQueue<Object> sharedQueue = new LinkedBlockingQueue<Object>(10);
        Consumer1 c1 = new Consumer1(sharedQueue);
        Producer1 p1 = new Producer1(sharedQueue);
        
        Thread t1 = new Thread(c1);
        Thread t2 = new Thread(p1);
        
        t2.start();
        t1.start();
        
    }
}


class Consumer1 implements Runnable
{
    private BlockingQueue<Object> Queue;
    Consumer1(BlockingQueue<Object> inpQueue)
    {
        this.Queue = inpQueue;
    }
    public void run()
    {
        while(true)
        {
            if(!Queue.isEmpty())
               {
                Object temp=Queue.remove();
                System.out.println("consumed "+temp);
               }
        }
    }
}


class Producer1 implements Runnable
{
    private BlockingQueue<Object> Queue;
    Producer1(BlockingQueue<Object> inpQueue)
    {
        this.Queue = inpQueue;
    }
    public void run()
    {
        int i=0;
        while(i<10)
        {
            System.out.println("produced "+i);
            Queue.add(i++);
        }
    }
}