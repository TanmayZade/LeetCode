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
    int idx;
    int kThSmall;
    public int kthSmallest(TreeNode root, int k) {
        idx = 0;
        inOrder(root, k);
        return kThSmall;
    }

    private void inOrder(TreeNode root, int k){
        if(root == null) return;
        inOrder(root.left, k);
        if(k == ++idx){
            kThSmall = root.val;
            return;
        }
        inOrder(root.right, k);
    }
}