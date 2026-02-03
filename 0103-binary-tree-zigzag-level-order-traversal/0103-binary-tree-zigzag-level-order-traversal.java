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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if(root == null) return res;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        boolean reverse = false;
        while(!q.isEmpty()){
            int level = q.size();
            ArrayList<Integer> levelEle = new ArrayList<>();
            while(level-- > 0){
                TreeNode curr = q.poll();
                if(curr.left != null) q.add(curr.left);
                if(curr.right != null) q.add(curr.right);
                levelEle.add(curr.val);
            }

            if(reverse) Collections.reverse(levelEle);
            res.add(levelEle);
            reverse = !reverse;
        }
        return res;
    }
}