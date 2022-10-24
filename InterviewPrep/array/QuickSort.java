package array;

public class QuickSort {

    public static void main(String[] args) {
        int a[] = {7, 9, 4, 2, 5};
        sort(a, 0, a.length-1);
        for (int x : a){
            System.out.print(x);
        }
    }

    public static void sort(int[] arr, int x, int y){
        sortInternal(arr, 0, arr.length-1);
    }

    private static void sortInternal(int[] arr, int start, int end){ // arr, start=0, end=5
        if (start < end){
            int partitionIndex = partition(arr, start, end);

            sortInternal(arr, start, partitionIndex-1);
            sortInternal(arr, partitionIndex+1, end);
        }
    }

    private static int partition(int[] arr, int start, int end){
        int pivot = arr[start], pIndex=start;  // pivot = 10
        int left = start, right = end;


        while(left < right){
            if (arr[left] <= pivot){ // left = 2 and right = 4
                left++;
            }

            if (arr[right] > pivot){ // left = 3
                right--;
            }

            if (left < right){  // left = 1, right=5 i.e 5 and 2 -> [10, 2, 1, 8, 3, 5] -> [10, 2, 1, 3, 8, 5]
                int temp = arr[left];
                arr[left] = arr[right];
                arr[right] = temp;
            }

        }

        arr[start] = arr[right];  // start=0, [1, 2, 1, 3, 8, 5]
        arr[right] = pivot;       // [1, 2, 10, 3, 8, 5]

        return right;
    }
}
