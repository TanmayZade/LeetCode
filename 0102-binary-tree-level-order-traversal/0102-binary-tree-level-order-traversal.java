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
    public List<List<Integer>> levelOrder(TreeNode root) {
        if(root == null) return new ArrayList<>();
        //using bfs
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        List<List<Integer>> res = new ArrayList<>();

        while(!q.isEmpty()){
            int level = q.size();
            List<Integer> levelEle = new ArrayList<>();
            while(level-- > 0){
                TreeNode curr = q.poll();
                levelEle.add(curr.val);
                if(curr.left != null) q.add(curr.left);
                if(curr.right != null) q.add(curr.right);
            }
            res.add(levelEle);
        }
        return res;
    }
}