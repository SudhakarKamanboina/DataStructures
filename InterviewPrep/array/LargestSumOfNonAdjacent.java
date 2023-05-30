package array;

/*
* This problem was asked by Airbnb.

Given a list of integers, write a function that returns the largest sum of non-adjacent numbers.
* Numbers can be 0 or negative.

For example, [2, 4, 6, 2, 5] should return 13, since we pick 2, 6, and 5. [5, 1, 1, 5] should return 10,
*  since we pick 5 and 5.

Follow-up: Can you do this in O(N) time and constant space?
* */

public class LargestSumOfNonAdjacent {

    public static void main(String[] args) {
        int[] nums = new int[]{2, 4, 6, 2, 5};
        System.out.println(largestSum(nums));

        //Solution for follow-up
        System.out.println("Follow-up Sol: "+followUpSol(nums));

    }

    private static int largestSum(int[] nums){
        int[] dp = new int[nums.length];

        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);

        for(int i=2; i<nums.length; i++){
            dp[i] = Math.max(dp[i-2] + nums[i], dp[i-1]);
        }

        return dp[nums.length-1];
    }

    // https://www.geeksforgeeks.org/maximum-sum-such-that-no-two-elements-are-adjacent/
    private static int followUpSol(int[] nums){
        int incl = nums[0];
        int excl =0;
        int excl_new =0;

        for(int i=1; i<nums.length; i++){
            excl_new = Math.max(incl, excl);

            incl = excl + nums[i];
            excl = excl_new;

        }

        return Math.max(incl, excl);
    }
}
