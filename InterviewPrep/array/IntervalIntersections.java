package array;

/*
You are given a shcedule of tasks to work on. Each tasks has a start and an end time [start, end] where end > start.
Find out for the given schedule:

in what intervals you are working (at least 1 task ongoing)
in what intervals you are multitasking (at least 2 tasks ongoing)
In other words, find union and intersection of a list of intervals. The input is sorted by start time.

Example:
Input: [[1, 10], [2, 6], [9, 12], [14, 16], [16, 17]]

Output union: [[1, 12], [14, 17]]
Explanation: We just need to merge overlapping intervals https://leetcode.com/problems/merge-intervals

Output intersection: [[2, 6], [9, 10]]
 */


import java.util.LinkedList;

// this is solution for second part of the above question
public class IntervalIntersections {

    public static void main(String[] args) {
        int[][] input = {{1, 10}, {2, 6}, {5, 8}, {9, 12}, {14, 16}, {16, 17}};
        int[][] res = getIntervalIntersection(input);
        for(int[] r : res){
            System.out.println(r[0] + ","+r[1]);
        }
    }

    private static int[][] getIntervalIntersection(int[][] input){
        if (input == null || input.length == 0)
            return new int[0][0];

        LinkedList<int[]> res = new LinkedList<>();
        int[] prev = input[0];

        for(int i=1; i<input.length; i++){
            int[] curr = input[i];
            if (prev[1] > curr[0]){ // intersection found
                int[] currIntersec = {Math.max(prev[0], curr[0]), Math.min(prev[1], curr[1])};
                if (!res.isEmpty() && res.peekFirst()[1] > currIntersec[0]){
                    int[] firstEntry = res.pollFirst();
                    currIntersec[0] = Math.min(firstEntry[0], currIntersec[0]);
                    currIntersec[1] = Math.max(firstEntry[1], currIntersec[1]);
                }
                res.add(currIntersec);
            }
            prev[0] = Math.max(prev[0], curr[0]);
            prev[1] = Math.max(prev[1], curr[1]);
        }

        int[][] intersections = new int[res.size()][2];
        int i=0;
        for(int[] record : res){
            intersections[i++] = record;
        }
        return intersections;
    }


}
