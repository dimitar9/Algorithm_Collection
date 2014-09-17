//http://blog.csdn.net/ljphhj/article/details/21369053
import java.util.ArrayList;  
import java.util.Stack;  
  
  
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
      
    public ArrayList<Integer> postorderTraversal(TreeNode root) {  
        ArrayList<Integer> list = new ArrayList<Integer>();  
        if (root == null)  
            return list;  
        Stack<TreeNode> stack = new Stack<TreeNode>();  
         
        stack.push(root);  
        while (stack.size() != 0){  
            TreeNode top = stack.peek();  
            if (top.left == null && top.right == null){  
                list.add(top.val);  
                stack.pop();  
            }  
            if (top.left != null){  
                stack.push(top.left);  
                top.left = null;  
                continue;  
            }  
            if (top.right != null){  
                stack.push(top.right);  
                top.right = null;  
                continue;  
            }  
        }  
       
        return list;  
    }  
}  
http://leetcode.com/2010/10/binary-tree-post-order-traversal.html
//see alternative solution



