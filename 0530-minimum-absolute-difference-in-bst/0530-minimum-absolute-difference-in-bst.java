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
    int prev = Integer.MAX_VALUE;
    int minDiff = Integer.MAX_VALUE;
    public int getMinimumDifference(TreeNode root) {
        inOrder(root);
        return minDiff;
    }

    private void inOrder(TreeNode root){
        if(root == null) return;
        if(root.left != null) inOrder(root.left);
        minDiff = Math.min(minDiff, Math.abs(prev - root.val));
        prev = root.val;
        if(root.right != null) inOrder(root.right);
    }
}