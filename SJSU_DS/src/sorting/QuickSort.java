package sorting;

public class QuickSort
{
    private int[] array;
    private int length;
    
    public static void main(String[] args)
    {
        int[] inputArr = {8, 1, 3, 5, 7};
        QuickSort obj = new QuickSort();
        obj.handler(inputArr);
    }
    
    private void handler(int[] inArr)
    {
        this.array = inArr;
        this.length = this.array.length;
        sort(0, length-1);
        for(int i=0; i<length; i++)
            System.out.println(array[i]);
    }
    
    private void sort(int low, int high)
    {
        int i=low, j=high;
     // Get the pivot element from the middle of the list
        int pivot = array[(low + high)/2];
        
        // Divide into two lists
        while(i<=j)
        {
            // If the current value from the left list is smaller then the pivot
            // element then get the next element from the left list
            while(array[i] < pivot)
                i++;
            
            // If the current value from the right list is larger then the pivot
            // element then get the next element from the right list
            while(array[j] > pivot)
                j--;
            
            // If we have found a values in the left list which is larger then
            // the pivot element and if we have found a value in the right list
            // which is smaller then the pivot element then we exchange the
            // values.
            // As we are done we can increase i and decrease j
            if(i <= j)
            {
                exchangeNumbers(i,j);
                for(int k=0; k<array.length;k++)
                    System.out.println(array[k]);
                System.out.println("---------------------------------------------");
                i++;
                j--;
            }
        }
        
        //Recursion - Both if conditions check whether more elements exist
        if(low < j)     // now as we are decrementing j, j should be equal to low so checking this condition
            sort(low, j);
        if(i < high)    // now as we are incrementing i, i should be equal to high so checking this condition
            sort(i, high);
    }

    private void exchangeNumbers(int i, int j)
    {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

}
