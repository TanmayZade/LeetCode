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
    int preIdx = 0;
    HashMap<Integer, Integer> inorderIdxMap = new HashMap<>();

    public TreeNode buildTree(int[] preOrder, int[] inorder) {
        int n = preOrder.length;
        for(int i = 0;i < n;i++)
            inorderIdxMap.put(inorder[i],i);

        return build(preOrder, 0, n-1);
    }

    private TreeNode build(int[] preOrder, int inStart, int inEnd){
        if(inStart > inEnd) return null;

        int rootVal = preOrder[preIdx++];
        TreeNode root = new TreeNode(rootVal);

        int idx = inorderIdxMap.get(rootVal);

        root.left = build(preOrder, inStart, idx-1);
        root.right = build(preOrder, idx+1, inEnd);

        return root;
    }
}