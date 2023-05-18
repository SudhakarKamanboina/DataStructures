package sliding_window;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// asked in Walmart interview in telephonic screen
//  Given an array and k, find a minimum length subarray that has atleast k distinct integers
/* e.g:
input: [2,2,1,1,3] k=3
output: 4
there are two subarrays with 3 distinct integers, [2,2,1,1,3] and [2,1,1,3]. The answer is latter
one as it has minimum length of 4
*
* */

// equivalent to https://www.geeksforgeeks.org/smallest-subarray-k-distinct-numbers/

public class MinimumLengthSubarray {

    public static void main(String[] args) {
        List<Integer> integers = new ArrayList<>();
        integers.add(2);
        integers.add(2);
        integers.add(1);
        integers.add(1);
        integers.add(3);
        int result = findMinimumLengthSubarray(integers, 3);

        System.out.println(result);
    }

    /*
     * Complete the 'findMinimumLengthSubarray' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER_ARRAY arr
     *  2. INTEGER k
     */

     /*
     0 > 2
     1 > 2,
     2 > 1,
     3 > 1,
     */
    public static int findMinimumLengthSubarray(List<Integer> arr, int k) {
        // Write your code here
        int start=0, end=0, n=arr.size(), counter=0, minLength= Integer.MAX_VALUE;
        Map<Integer, Integer> map = new HashMap();

        while(end < n){

            int element = arr.get(end);
            if(map.containsKey(element)) {
                map.put(element, map.get(element)+1);
            } else {
                map.put(element, 1);
                counter++;
            }
            end++;

            while(counter == k){

                if (map.get(arr.get(start)) > 1){
                    map.put(arr.get(start), map.get(arr.get(start))-1);
                } else {
                    counter--;
                }
                start++;

                minLength = Math.min(minLength, (end - start) + 1);
            }
        }

        return minLength == Integer.MAX_VALUE ? -1 : minLength;

    }
}
