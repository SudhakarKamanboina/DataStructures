package sorting;

public class SelectionSort
{

    /**
     * @param args
     */
    public static void main(String[] args)
    {
        arrayTSort a = new arrayTSort(8);
        a.insert(99);
        a.insert(17);
        a.insert(272);
        a.insert(35);
        a.insert(202);
        a.insert(59);
        a.insert(55);
        a.insert(88);
        
        //a.display();
        
        a.selectionSort();

    }

}

class arrayTSort
{
    long a[];
    int nElem;
    
    public arrayTSort(int maxSize)
    {
        a = new long[maxSize];
        nElem =0;
    }
    
    public void insert(long val)
    {
        a[nElem] = val;
        nElem++;
    }
    
    public void selectionSort()
    {
        int out, in, min;
        for(out=0; out<nElem-1; out++)
        {
            min = out;
            for(in=out+1; in<nElem; in++)
            {
                if(a[in] < a[min])
                {
                    min = in;
                }
            }
            swap(out, min);
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

