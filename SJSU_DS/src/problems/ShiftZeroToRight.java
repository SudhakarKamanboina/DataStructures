package problems;

import java.util.Arrays;

// Shift zero's to right and maintain order of elements
public class ShiftZeroToRight
{

    /**
     * @param args
     */
    public static void main(String[] args)
    {
        int a[] ={8, 9, 0, 4, 3, 0, 0, 5}, count=0;
        
        for(int i=0; i<a.length;i++)
            if(a[i] != 0)
                a[count++]=a[i];
        
        while(count<a.length)
        {
            a[count++]=0;
        }
            System.out.println(Arrays.toString(a));
    }

}
