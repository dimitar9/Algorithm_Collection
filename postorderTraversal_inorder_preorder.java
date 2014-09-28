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


1:    vector<int> inorderTraversal(TreeNode *root) {  
2:      // Start typing your C/C++ solution below  
3:      // DO NOT write int main() function  
4:      vector<TreeNode*> sta;  
5:      vector<int> result;  
6:      if(root == NULL) return result;  
7:      TreeNode* node =root;  
8:      while(sta.size()>0 || node!=NULL)  
9:      {  
10:        while(node!=NULL)  
11:        {  
12:          sta.push_back(node);  
13:          node = node->left;  
14:        }  
15:        node= sta.back();  
16:        sta.pop_back();  
17:        result.push_back(node->val);  
18:        node =node->right;  
19:      }  
20:      return result;  
21:    }  


// An iterative process to print preorder traversal of Binary tree
void iterativePreorder(node *root)
{
    // Base Case
    if (root == NULL)
       return;
 
    // Create an empty stack and push root to it
    stack<node *> nodeStack;
    nodeStack.push(root);
 
    /* Pop all items one by one. Do following for every popped item
       a) print it
       b) push its right child
       c) push its left child
    Note that right child is pushed first so that left is processed first */
    while (nodeStack.empty() == false)
    {
        // Pop the top item from stack and print it
        struct node *node = nodeStack.top();
        printf ("%d ", node->data);
        nodeStack.pop();
 
        // Push right and left children of the popped node to stack
        if (node->right)
            nodeStack.push(node->right);
        if (node->left)
            nodeStack.push(node->left);
    }
}


