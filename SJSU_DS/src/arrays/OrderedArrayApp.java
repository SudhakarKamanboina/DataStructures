package arrays;

public class OrderedArrayApp
{
    public static void main(String arg[])
    {
        int result;
        OrderedArray a = new OrderedArray(20);
        a.insert(9);
        a.insert(17);
        a.insert(26);
        a.insert(35);
        a.insert(48);
        a.insert(59);
        a.insert(88);
        a.insert(99);
        
        a.display();
        
        result = a.find(59);
        if(result != a.getSize())
            System.out.println("Element found at position "+ result);
     
        a.delete(88);
        a.display();
    }
}



class OrderedArray
{
    private long[] arrEle;
    private int noOfElem;
    
    OrderedArray(int maxSize)
    {
        arrEle = new long[maxSize];
        noOfElem = 0;
    }
    
    public int getSize()
    {
        return noOfElem;
    }
    
    public void insert(long val)
    {
        int i;
        for(i=0; i<noOfElem; i++)
            if(val < arrEle[i])
                break;
        
        for(int j=noOfElem; j>i; j--)
            arrEle[j]=arrEle[j-1];
        
        arrEle[i] = val;
        noOfElem++;
    }
    
    //binary search
    public int find(long key)
    {
        int lower = 0;
        int upper = noOfElem-1;
        int mid;
        
        while(true)
        {
            mid = (lower+upper)/2;
            
            if(key == arrEle[mid])
                return mid;
            if(lower > upper)
                return noOfElem;
            
            if(key < arrEle[mid])
            {
                upper = mid-1;
            }
            else
            {
                lower = mid+1;
            }
        }
    }
    
    public boolean delete(long val)
    {
        int i;
        i = find(val);
            if(i == noOfElem)
                return false;
            else   
                {   
                    for(int j=i; j<noOfElem; j++)
                    arrEle[j]=arrEle[j+1];
                    noOfElem--;
                    return true;
                }
    }
    
    public void display()
    {
        for(int i=0; i<noOfElem; i++)
            System.out.println(arrEle[i]);
    }
}
