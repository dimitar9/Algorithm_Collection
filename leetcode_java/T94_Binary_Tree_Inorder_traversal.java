import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class T94 {
	/**
	 * Definition for binary tree
	 * public class TreeNode {
	 *     int val;
	 *     TreeNode left;
	 *     TreeNode right;
	 *     TreeNode(int x) { val = x; }
	 * }
	 */
	public  List<Integer> inorderTraversal(TreeNode root) {
		List<Integer>  list = new ArrayList<>();
		Stack<TreeNode> stack = new Stack<>();
		TreeNode cur = root;
		while(cur != null || !stack.empty() ){
			while(cur!=null){
				stack.push(cur);
				cur = cur.left;
			}
			cur = stack.pop();
			list.add(cur.val);
			cur = cur.right;
			
		}
		return list;
	}
	 
	 public  static  void main(String[] args){
		 T94 t94 = new T94();
		 List<Integer> returnList = new ArrayList<>();
		 TreeNode root = new TreeNode(1);
		 TreeNode node2 = new TreeNode(2);
		 TreeNode node3 = new TreeNode(3);
		 root.right = node2;
		 node2.left = node3;
		 returnList = t94.inorderTraversal(root);
		 
		 for(int val : returnList) {
			 System.out.println(val);
		 }
	 }
}
