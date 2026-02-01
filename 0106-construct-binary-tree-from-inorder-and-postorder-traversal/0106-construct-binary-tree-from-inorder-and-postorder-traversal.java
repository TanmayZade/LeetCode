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
    int postIdx;
    HashMap<Integer, Integer> inorderIdxMap = new HashMap<>();
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        int n = inorder.length;
        postIdx = postorder.length-1;
        for(int i =0;i < n;i++)
            inorderIdxMap.put(inorder[i],i);
        
        return build(postorder, 0, n-1);
    }

    private TreeNode build(int[] postOrder, int inStart, int inEnd){
        if(inStart > inEnd) return null;

        int rootVal = postOrder[postIdx--];
        TreeNode root = new TreeNode(rootVal);

        int idx = inorderIdxMap.get(rootVal);
        root.right = build(postOrder, idx+1, inEnd);
        root.left = build(postOrder, inStart, idx-1 );

        return root;
    }
}