package sorting;

import java.util.Arrays;


public class BubbleSort
{

    /**
     * @param args
     */
    public static void main(String[] args)
    {
        arrayToSort a = new arrayToSort(5);
        a.insert(2);
        a.insert(1);
        a.insert(5);
        a.insert(4);
        a.insert(3);
        /*a.insert(59);
        a.insert(55);
        a.insert(88);*/
        
        //a.display();
        
        a.optimized_bubble();

    }

}

class arrayToSort
{
    long a[];
    int nElem;
    
    public arrayToSort(int maxSize)
    {
        a = new long[maxSize];
        nElem =0;
    }
    
    public void insert(long val)
    {
        a[nElem] = val;
        nElem++;
    }
    
    public void basic_bubble()
    {
        int i,j,k;
        long temp;
        
        for(i=0;i<nElem;i++)
        {
          for(j=0;j<nElem-1;j++)
          {
              if(a[j]>a[j+1])
                 {
                    temp=a[j];
                    a[j]=a[j+1];
                    a[j+1]=temp;
                }
              System.out.println("\nAfter iteration   i="+  i + " j = "+j );
              System.out.println(Arrays.toString(a));
          }
          System.out.println("\nAfter pass   i="+  i + " j = "+j );
              System.out.println(Arrays.toString(a));
         }
          
      display();
    }
    
    public void optimized_bubble()
    {
        /*int i;
        for(i=nElem-1; i>1; i--)
        {
            for(int j=0;j<i;j++)
            {
                if(a[j] > a[j+1])
                    swap(j, j+1);
            }
        }*/
        
        int i,j,k;
        long temp;
        
        //System.out.println("\nUnsorted Data:");
            //System.out.println(Arrays.toString(a));
        
        for(i=0;i<nElem-1;i++)
          {
            for(j=i;j<nElem-i-1;j++)
            {
                if(a[j]>a[j+1])
                   {
                      temp=a[j];
                      a[j]=a[j+1];
                      a[j+1]=temp;
                  }
                System.out.println("\nAfter iteration   i="+  i + " j = "+j );
                System.out.println(Arrays.toString(a));
            }
            System.out.println("\nAfter pass   i="+  i + " j = "+j );
                System.out.println(Arrays.toString(a));
           }
            
        display();
    }

    public void swap(int index1, int index2)
    {
        long temp=0;
        temp = a[index1];
        a[index1] = a[index2];
        a[index2] = temp;
    }
    
    public void display()
    {
        System.out.println("\nSorted Data:");
            System.out.println(Arrays.toString(a));
    }
}
