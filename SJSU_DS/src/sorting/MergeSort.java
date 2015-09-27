package sorting;

public class MergeSort
{

    private int[] numbers;
    private int[] helper;
    private int number;
    
    public static void main(String[] args)
    {
        MergeSort obj1 = new MergeSort();
        
        obj1.sort(new int[]{100, 98, 82, 75, 64, 32, 18});
    }
    
    public void sort(int[] values)
    {
        this.numbers = values;
        this.number = values.length;
        this.helper = new int[number];
        mergeSort(0, number-1);
        for(int i=0; i<numbers.length; i++)
            System.out.println(numbers[i]);
    }

    public void mergeSort(int low, int high)
    {
        int mid;
     // check if low is smaller then high, if not then the array is sorted
        if(low < high)
        {
            mid = (low + high)/2;
            mergeSort(low, mid);
            
            mergeSort(mid+1, high);
            
            merge(low, mid, high);
        }
            
    }
    
    public void merge(int low, int mid, int high)
    {
        for(int i=low; i<=high; i++)
        {
            helper[i] = numbers[i];
        }
        
        int i = low;
        int j = mid+1;
        int k = low;
        
        // Copy the smallest values from either the left or the right side back
        // to the original array
        while(i <= mid && j <= high)
        {
            if(helper[i] <= helper[j])
            {
                numbers[k] = helper[i];
                i++;
            }
            else
            {
                numbers[k] = helper[j];
                j++;
            }
            k++;
        }
        
     // Copy the rest of the left side of the array into the target array
        while(i <= mid)
        {
            numbers[k] = helper[i];
            i++;
            k++;
        }
    }
}
