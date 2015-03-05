/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

public class BSTIterator {
    
    ArrayList<Integer> values=new ArrayList<Integer>();
    int len;
    int index;
    
    public BSTIterator(TreeNode root) {
        int index = 0;
        Stack<TreeNode> stack = new Stack<TreeNode>();
        while(root!=null || !stack.empty()) {
            if(root !=null){
                stack.push(root);
                root=root.left;
            } else {
                TreeNode node = stack.pop();
                values.add(node.val);
                root = node.right;
            }
        }    
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return (index<=values.size()-1);
        
    }

    /** @return the next smallest number */
    public int next() {
        if(hasNext()){
            return values.get(index++);
        } else {
            return -1;
        }
    }
}

/**
 * Your BSTIterator will be called like this:
 * BSTIterator i = new BSTIterator(root);
 * while (i.hasNext()) v[f()] = i.next();
 */
