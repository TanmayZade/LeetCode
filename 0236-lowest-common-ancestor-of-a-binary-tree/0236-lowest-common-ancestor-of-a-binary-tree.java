/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null) return root;
        if (root == p || root == q) return root;
        if(hasNode(root.left, p) && hasNode(root.right, q)) return root;
        if(hasNode(root.right, p) && hasNode(root.left, q)) return root;

        TreeNode leftLCA = lowestCommonAncestor(root.left, p, q);
        TreeNode rightLCA = lowestCommonAncestor(root.right, p, q);

        return leftLCA != null ? leftLCA : rightLCA;
    }

    private boolean hasNode(TreeNode root, TreeNode p){
        if(root == null) return false;

        return root == p || hasNode(root.left, p) || hasNode(root.right, p);
    }
}