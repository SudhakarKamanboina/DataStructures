package sorting;

public class InsertionSort
{
    /**
     * @param args
     */
    public static void main(String[] args)
    {
        arrayTISort a = new arrayTISort(8);
        a.insert(99);
        a.insert(17);
        a.insert(272);
        a.insert(35);
        a.insert(202);
        a.insert(59);
        a.insert(55);
        a.insert(88);
        
        //a.display();
        
        a.insertionSortOptimized();

    }

}

class arrayTISort
{
    long a[];
    int nElem;
    
    public arrayTISort(int maxSize)
    {
        a = new long[maxSize];
        nElem =0;
    }
    
    public void insert(long val)
    {
        a[nElem] = val;
        nElem++;
    }
    
    public void insertionSortOptimized()
    {
        int out, in; 
        long temp;
        for(out=1; out<nElem; out++)
        {
            temp = a[out];
            in = out;
            while(in>0 && a[in-1]>temp)
            {
                a[in]=a[in-1];
                in--;
            }
            a[in] = temp;
            
        }
        display();
    }

    public void insertionSort()
    {
        int i, j;
        long temp;
        for(i=1; i<nElem; i++)
        {
            j=i;
            while(j>0 && a[j-1]>a[j])
            {
                temp = a[j];
                a[j]= a[j-1];
                a[j-1] = temp;
                j--;
            }
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
        for(int i=0; i<nElem; i++)
            System.out.println(a[i]);
    }
}
