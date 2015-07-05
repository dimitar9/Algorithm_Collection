/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
public int sumNumbers(TreeNode root) {
    return sum(root, 0);
}

public int sum(TreeNode n, int s){
    if (n == null) return 0;
    if (n.right == null && n.left == null) return s*10 + n.val;
    return sum(n.left, s*10 + n.val) + sum(n.right, s*10 + n.val);
}

}
