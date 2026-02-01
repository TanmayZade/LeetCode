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
    public boolean isSameTree(TreeNode p, TreeNode q) {
        ArrayList<Integer> preOrderP = new ArrayList<>();
        ArrayList<Integer> preOrderQ = new ArrayList<>();

        calculatePreOrder(p,preOrderP);
        calculatePreOrder(q,preOrderQ);

        if(preOrderP.equals(preOrderQ)) return true;
        else return false;
    }

    public void calculatePreOrder(TreeNode root, ArrayList<Integer> preOrder){
        if(root == null){
            preOrder.add(null);
            return;
        }
        preOrder.add(root.val);
        calculatePreOrder(root.left, preOrder);
        calculatePreOrder(root.right, preOrder);
    }
}