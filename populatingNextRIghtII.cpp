/**
 * Definition for binary tree with next pointer.
 * public class TreeLinkNode {
 *     int val;
 *     TreeLinkNode left, right, next;
 *     TreeLinkNode(int x) { val = x; }
 * }
 */
public class Solution {
    //dfs 
    public void connect(TreeLinkNode root) {
        if (root == null) return;
        
        //如果右孩子不为空，左孩子的next是右孩子。
        //反之，找root next的至少有一个孩子不为空的节点
        if (root.left != null) {
            if (root.right != null) {
                root.left.next = root.right;
            }
            else {
                TreeLinkNode p = root.next;
                while (p != null && p.left == null && p.right == null)
                    p = p.next;
                if (p != null)
                    root.left.next = p.left == null ? p.right : p.left;
            }
        }
        
        //右孩子的next 根节点至少有一个孩子不为空的next
        if (root.right != null) {
            TreeLinkNode p = root.next;
            while (p != null && p.left == null && p.right == null)
                p = p.next;
            if (p != null)
                root.right.next = p.left == null ? p.right : p.left;
        }
        connect(root.right);    
        connect(root.left);
    }
}
