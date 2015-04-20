/*
Implement Iterator for BinaryTree I (In-order)
Implement In-order Iterator for Binary Tree

Suppose the data structure for a Tree node is as follows:
public class TreeNode {
  int val;
  TreeNode left;
  TreeNode right;
  TreeNode(int x) { val = x; }
}
Provide an implementation of the following interface: 
public interface InOrderBinaryTreeIterator extends Iterator<Integer> { 
   Returns the next integer a in the in-order traversal of the given binary tree.
   * For example, given a binary tree below,
   *       4
   *      / \
   *     2   6
   *    / \ / \
   *   1  3 5  7
   * the outputs will be 1, 2, 3, 4, 5, 6, 7. 
    
  public Integer next(); 

   Return true if traversal has not finished; otherwise, return false.
   
  public boolean hasNext();
}
Solution

The idea is still the same as we discussed in previous post):
Find the left-most node of the root and store previous left children in a stack;
Pop up the top node from the stack;
If it has a right child, find the lef-most node of the right child and store left children in the stack.
*/
 public class InOrderBinaryTreeIteratorImpl implements InOrderBinaryTreeIterator {  
   Stack<TreeNode> stack = new Stack<TreeNode>();  
   
   /** Push node cur and all of its left children into stack */  
   private void pushLeftChildren(TreeNode cur) {  
     while (cur != null) {  
       stack.push(cur);  
       cur = cur.left;  
     }  
   }  
   
   /** Constructor */  
   public InOrderBinaryTreeIterator(TreeNode root) {  
     pushLeftChildren(root);  
   }  
   
   /** {@inheritDoc} */  
   @Override  
   public boolean hasNext() {  
     return !stack.isEmpty();  
   }  
   
   /** {@inheritDoc} */  
   @Override  
   public Integer next() {  
     if (!hasNext()) {  
       throw new NoSuchElementException("All nodes have been visited!");  
     }  
   
     TreeNode res = stack.pop();  
     pushLeftChildren(res.right);  
   
     return res.val;  
   }  
   
   @Override  
   public void remove() {  
     throw new UnsupportedOperationException("remove() is not supported.");  
   }  
 }  
//This iterator takes extra spaces for the stack, which is O(h) at worst case, where h is the height of the tree.
//
//With this iterator in hand, an in-order traversal of a binary tree can be implemented as follows.
// public ArrayList<Integer> inorderTraversal(TreeNode root) {  
//   InOrderBinaryTreeIterator iterator = new InOrderBinaryTreeIteratorImpl(root); 
//   ArrayList<Integer> results = new ArrayList<Integer>();
//   while (iterator.hasNext()) {   
//     results.add(iterator.next());  
//   }   
//   return results;    
// }
