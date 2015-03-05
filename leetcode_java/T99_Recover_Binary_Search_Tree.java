/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class T99 {
    TreeNode firstNode = null;
    TreeNode secondNode = null;
    TreeNode prevNode = new TreeNode(Integer.MIN_VALUE);
    public void recoverTree(TreeNode root) {
        if (root == null) return;
        traverse(root);
        
        int tmp = firstNode.val;
        firstNode.val = secondNode.val;
        secondNode.val = tmp;
      
        
    }
    void traverse(TreeNode root){
        if (root==null) return;
        traverse(root.left);
        
        if(firstNode == null && prevNode.val >= root.val){
            firstNode = prevNode;
        }
        if(firstNode !=null && prevNode.val >= root.val){
            secondNode = root; //TRAP. IMportant. Don't write it as prevNode.
        }
        prevNode = root;
        traverse(root.right);
    }
}
