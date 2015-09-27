package arrays;
import java.util.Comparator;
import java.util.Iterator;
import java.util.TreeSet;

public class MergeNSortArrayUsingAPI
{
    public static void main(String arg[])
    {
        int[] a1 = {1, 2, 3, 1, 7};
        int[] a2 = {4, 5, 4, 6, 7};
        int size = 0, j = 0;
        TreeSet<Integer> temp = new TreeSet<Integer>(new Comparator<Integer>()
        {

            @Override
            public int compare(Integer paramT1, Integer paramT2)
            {
                // TODO Auto-generated method stub
                return paramT1 - paramT2;
            }
        });
        for (int i = 0; i < a1.length; i++)
        {
            temp.add(a1[i]);
        }
        for (int i = 0; i < a2.length; i++)
        {
            temp.add(a2[i]);
        }
        Iterator<Integer> itr = temp.iterator();
        while (itr.hasNext())
        {
            itr.next();
            size++;
        }
        int result[] = new int[size];
        Iterator<Integer> itr2 = temp.iterator();
        while (itr2.hasNext())
        {
            result[j] = itr2.next();
            j++;
        }
        
        for (int x = 0; x < result.length; x++)
            System.out.println("output " + result[x]);
    }
}
