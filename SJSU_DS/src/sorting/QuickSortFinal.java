package sorting;

// refer this
public class QuickSortFinal
{

    /**
     * @param args
     */
    public static void main(String[] args)
    {
        int a[] = {7, 9, 4, 2, 5};
        QuickSort(a, 0, a.length-1);
        
        for(int i=0; i<a.length;i++)
        {
            System.out.println("element  "+a[i]);
        }
    }

    private static void QuickSort(int[] a, int low, int high)
    {
        int pivot;
        if(low < high)
        {
            pivot = partition(a, low, high);
            QuickSort(a, low, pivot-1);
            QuickSort(a, pivot+1, high);
            
        }
    }

    private static int partition(int[] a, int low, int high)
    {
        int left, right, pivot_element = a[low];
        left = low;
        right = high;
        
        while(left < right)
        {
            if(a[left]<=pivot_element)
                left++;
            
            if(a[right]>pivot_element)
                right--;
            
            if(left < right)
            {
                int temp;
                temp = a[left];
                a[left] = a[right];
                a[right] = temp;
            }
        }
        
        a[low] = a[right];
        a[right] = pivot_element;
        return right;
    }

}
