/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if(root == null) return false;
        return PathSum(root, targetSum, 0);
    }

    public boolean PathSum(TreeNode root, int targetSum, int currSum){
        if(root == null) return false;
        //leafnode
        if(root.left == null && root.right == null){
            currSum += root.val;
            if(currSum == targetSum) return true;
            else{
                currSum -= root.val;
                return false;
            }
        }
        currSum += root.val;
        boolean leftCheck = PathSum(root.left, targetSum, currSum);
        boolean rightCheck = PathSum(root.right, targetSum, currSum);
        currSum -= root.val;
        return leftCheck || rightCheck;
    }
}