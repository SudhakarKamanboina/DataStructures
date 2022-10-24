package dp;

/*
You are given a 2-d matrix where each cell represents number of coins in that cell. Assuming we start at matrix[0][0],
 and can only move right or down, find the maximum number of coins you can collect by the bottom right corner.

For example, in this matrix

0 3 1 1
2 0 0 4
1 5 3 1
The most we can collect is 0 + 2 + 1 + 5 + 3 + 1 = 12 coins.
 */

// Similar question minimum path sum
//https://leetcode.com/problems/minimum-path-sum/

public class MaximumCoinPath {
    public static void main(String[] args) {
        int[][] grid = new int[3][4];
        grid[0] = new int[]{0, 3, 1, 1};
        grid[1] = new int[]{2, 0, 0, 4};
        grid[2] = new int[]{1, 5, 3, 1};

        int res = getMaximumPath(grid);
        System.out.println(res);
    }

    public static int getMaximumPath(int[][] grid){
        int row = grid.length, col = grid[0].length;
        int[][] dp = new int[row][col];

        for(int i=0; i<row; i++){
            for(int j=0; j<col; j++){
                dp[i][j] = grid[i][j];  // copy the value from grid cell to dp cell



                // get dp cell value from left or top and add it to current dp cell
                if (i>0 && j>0){
                    dp[i][j] += Math.max(dp[i-1][j], dp[i][j-1]);
                } else if (i>0){
                    dp[i][j] += dp[i-1][j];
                } else if (j>0){
                    dp[i][j] += dp[i][j-1];
                }
            }
        }
        return dp[row-1][col-1];
    }
}
