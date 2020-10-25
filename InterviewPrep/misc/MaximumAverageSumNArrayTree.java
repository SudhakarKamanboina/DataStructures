package misc;

//Given an N-ary tree, find the subtree with the maximum average. Return the root of the subtree.
//A subtree of a tree is the node which have at least 1 child plus all its descendants.
// The average value of a subtree is the sum of its values, divided by the number of nodes.

/*Input:
         20
        /   \
      12      18
    /  | \    / \
   11  2  3  15  8

Output: 18
Explanation:
There are 3 nodes which have children in this tree:
12 => (11 + 2 + 3 + 12) / 4 = 7
18 => (18 + 15 + 8) / 3 = 13.67
20 => (12 + 11 + 2 + 3 + 18 + 15 + 8 + 20) / 8 = 11.125

18 has the maximum average so output 18. */


import java.util.List;

public class MaximumAverageSumNArrayTree {

    double maxAvg = 0;
    double getMaxAverage(TreeNode root){
        helper(root);
        return maxAvg;
    }

    double[] helper(TreeNode root){

        int count = 1, currSum = root.val;
        for (TreeNode child : root.children){
            double[] res = helper(child);
            currSum += res[0];
            count += res[1];
        }
        maxAvg = Math.max(1.0 * currSum / count, maxAvg); // multiply by 1.0 to convert int to double
        return new double[]{currSum, count};
    }


    class TreeNode{
        public int val;
        public List<TreeNode> children;
    }
}
