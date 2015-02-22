/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
public List<Integer> postorderTraversal(TreeNode root) {
    Stack<TreeNode> traversal = new Stack<TreeNode>();
    List<Integer> res = new LinkedList<Integer>();

    if(root == null)
        return res;

    traversal.push(root);
    while(!traversal.isEmpty()){
        TreeNode top = traversal.pop();
        res.add(0, top.val);

        if(top.left != null){
            traversal.push(top.left);
        }

        if(top.right != null){
            traversal.push(top.right);
        }
    }
    return res;
}
}
//USE list!!!
