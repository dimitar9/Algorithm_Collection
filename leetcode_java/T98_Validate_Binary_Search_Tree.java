public class Solution {
    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }
        if (root.left == null && root.right == null) {
            return true;
        }
        return check(root, Integer.MAX_VALUE, Integer.MIN_VALUE);
    }

    public boolean check(TreeNode node, int max, int min) {
        if (node == null) {
            return true;
        }
        if (node.val > max || node.val < min) {
            return false;
        }

        // if node's value is INT_MIN, it should not have left child any more
        if (node.val == Integer.MIN_VALUE && node.left != null) {
            return false;
        }

        // if node's value is INT_MAX, it should not have right child any more
        if (node.val == Integer.MAX_VALUE && node.right != null) {
            return false;
        }

        return check(node.left, node.val - 1, min) && check(node.right, max, node.val + 1);
    }
}
