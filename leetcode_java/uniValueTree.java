
public class uniValueTree {
	public int countUniTree(TreeNode root){
		if(root.left == null && root.right == null) return 1;
		
		return helper(root);
	}
	
	private int helper(TreeNode node){
		if(node.left == null && node.right == null){
			return 1;
		}
		if(node.left == null){
			if(isUni(node.right)){
				if(node.val == node.right.val){
					return 1 + helper(node.right);
				}else{
					return helper(node.right);
				}
			}
		}
		else if(node.right == null){
			if(isUni(node.left)){
				if(node.val == node.left.val){
					return 1 + helper(node.left);
				} else {
					return helper(node.left);
				}
			}			
		}
		else if(isUni(node.left) && isUni(node.right) && (node.val == node.left.val) && (node.val == node.right.val)){
			return 1 + helper(node.left) + helper(node.right);
		}	
		return helper(node.left) + helper(node.right);
		
	}
	private boolean isUni(TreeNode node){
		return (node != null) && (node.left == null && node.right == null) ;
	}
	
	
	
	public static void main(String[] args){
		TreeNode root = new TreeNode(2);
		root.left = new TreeNode(1);
		root.left.left = new TreeNode(1);
		root.left.right = new TreeNode(1);
		root.right = new TreeNode(3);
		uniValueTree ut = new uniValueTree();
		int ret  = ut.countUniTree(root);
		System.out.println(ret);
	}
	//       2
	//      / \
	//     1   3
	//    / \
	//   1   1
	//
	
}



