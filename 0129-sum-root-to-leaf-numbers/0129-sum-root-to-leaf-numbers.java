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
    int sum = 0;

    public int sumNumbers(TreeNode root) {
        if(root == null) return 0;
        calcSum(root,"");
        return sum;
    }


    private String calcSum(TreeNode root, String number){
        if(root == null) return number;

        if(root.left == null && root.right == null){
            String number1 = "";
            number1 += number + root.val;
            sum += Integer.valueOf(number1);
            return number;
        }
        String number1 = "";
        number1 += number + root.val;
        calcSum(root.left, number1);
        calcSum(root.right, number1);
        return number;
    }


}