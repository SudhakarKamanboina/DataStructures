package searching;

public class BinarySearch
{
    public static void main(String arg[])
    {
        int arr[] = {8, 17, 34, 41, 59, 75, 89, 90, 99};
        Processing obj = new Processing();
        String output = obj.binSearch(arr, 75, 0, arr.length-1);
        System.out.println("Output is "+output);
        
    }
}


class Processing
{
    String binSearch(int[] arrElmnts, int key, int minElem, int maxElem)
    {
        String result = null;
        int mid;
        if(arrElmnts.length ==0 || maxElem < minElem)
            return result = "Invalid Array Elements";
        mid = (minElem + maxElem)/2;
        
            if(key > arrElmnts[mid])
                binSearch(arrElmnts, key, mid+1, maxElem);
            else if(key < arrElmnts[mid])
                binSearch(arrElmnts, key, minElem, mid-1);
            else
                return "Element found at position "+ mid;
        
            return result;
    }
}