package array;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

public class KthDistinctLargest {

    public static void main(String[] args) {
        System.out.println(solution(new int[]{3, 2, 1, 5,5, 6,6, 4}, 2));
    }

    static int solution(int[] nums, int k){
        Set<Integer> set = new HashSet();

        for(int num : nums)
            set.add(num);

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int num : set){
            pq.add(num);

            if (pq.size() > k)
                pq.poll();
        }
        return pq.poll();
    }
}
