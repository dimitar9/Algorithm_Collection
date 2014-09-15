//http://blog.csdn.net/ljphhj/article/details/21369053
import java.util.ArrayList;  
import java.util.Stack;  
  
  
class TreeNode {  
    int val;  
    TreeNode left;  
    TreeNode right;  
  
    TreeNode(int x) {  
        val = x;  
    }  
}  
public class Solution {  
      
    public ArrayList<Integer> postorderTraversal(TreeNode root) {  
        if (root == null)  
            return null;  
        ArrayList<Integer> list = new ArrayList<Integer>();  
        Stack<TreeNode> stack = new Stack<TreeNode>();  
        //先把最后访问的结点先放入到栈中，即根节点root  
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
