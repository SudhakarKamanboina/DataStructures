package dp;

//https://leetcode.com/problems/longest-common-subsequence/

/*
Input: text1 = "abcde", text2 = "ace"
Output: 3
Explanation: The longest common subsequence is "ace" and its length is 3.
 */


// Note: string1.length() - lcs gives minimum deletions
// Note: string2.legnth() - lcs gives minimum insertions/additions

public class LongestCommonSubsequence {

    public static void main(String args[]){
        int res = longestCommonSubsequence("abcde", "ace");
        System.out.println(res);

        //this is extra to print the operations performed to reach tex
    }


    // Write down the dp matrix on notebook for understanding. Both 0th row and col should be kept zero.
/*
   |
   |0 1 2 3 4 5
   |  a b c d e
---|-------------
0  |0 0 0 0 0 0
1 a|0 1 1 1 1 1
2 c|0 1 1 2 2 2
3 e|0 1 1 2 2 3

 */
    public static int longestCommonSubsequence(String text1, String text2) {

        int m = text1.length();
        int n = text2.length();
        int[][] dp = new int[m+1][n+1];

        for(int i=0; i<=m; i++){
            for (int j=0; j<=n; j++){
                if (i==0 || j==0)
                    continue;

                if (text1.charAt(i-1) == text2.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1] + 1;
                }else{
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }

        return dp[m][n];
    }
}
