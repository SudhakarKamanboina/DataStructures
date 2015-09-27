package arrays;

public class MergeArrays
{

    public static void main(String[] args)
    {
       int[] arr1 = {3, 5, 7, 9};
       int[] arr2 = {4, 8, 9, 11, 15, 19};
       MergeArrays obj = new MergeArrays();
       obj.merge(arr1, arr2);
    }
    
    private void merge(int[] arr1, int[] arr2)
    {
        int[] newArray = new int[arr1.length + arr2.length];
        int i=0, j=0, k=0;
        
        while(i < arr1.length && j < arr2.length)
        {
            if(arr1[i] < arr2[j])
            {
                newArray[k] = arr1[i];
                i++;
            }
            else
            {
                newArray[k] = arr2[j];
                j++;
            }
            k++;
        }
        
        while(i < arr1.length)
        {
            newArray[k] = arr1[i];
            i++;
            k++;
        }
        
        while(j < arr2.length)
        {
            newArray[k] = arr2[j];
            j++;
            k++;
        }
        
        for(int l=0; l <newArray.length; l++)
            System.out.println(newArray[l]);
    }

}
