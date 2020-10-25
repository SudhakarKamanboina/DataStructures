package searching;

public class BinarySearchTemplate3
{

    // find index of minimum element in shifted array
    public static void main(String arg[])
    {
        int arr[] = {4, 5, 6, 7, 0, 1, 2};
        Processing obj = new Processing();
        int output = indexOfMinimumVal(arr)
        System.out.println("Output is "+output);

    }

    static int indexOfMinimumVal(int[] arr){
        int start =0, end=arr.length-1, mid=0;

        while(start+1 < end){
            mid = satrt + (end - start)/2;
            if (arr[mid] > arr[end])
                start = mid;
            else
                end = mid;
        }
        return arr[start] < arr[end] : start ? end;
    }
}