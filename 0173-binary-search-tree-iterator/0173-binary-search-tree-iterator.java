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
class BSTIterator {
    TreeNode nextNode;
    ArrayList<Integer> inOrderTraversal;
    int currIdx;
    public BSTIterator(TreeNode root) {
        nextNode = root;
        inOrderTraversal = new ArrayList<>();
        inOrder(root);
        currIdx = -1;
    }
    
    public int next() {
        return inOrderTraversal.get(++currIdx);
    }

    private void inOrder(TreeNode root){
        if(root == null) return;

        inOrder(root.left);
        //root
        inOrderTraversal.add(root.val);
        inOrder(root.right);
    }
    public boolean hasNext() {
       return currIdx < inOrderTraversal.size()-1 ? true : false;
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */