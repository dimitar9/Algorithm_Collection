public class Solution {
public List<Integer> preorderTraversal(TreeNode root) {
    List<Integer> ret = new ArrayList<Integer>();
    Stack<TreeNode> st = new Stack<TreeNode>();
    
    if(root == null) return ret;
    st.push(root);
    while(!st.isEmpty()){
        TreeNode top = st.pop();
        ret.add(top.val);
        if(top.right!=null) st.push(top.right);
        if(top.left!=null) st.push(top.left);
    }
    return ret;
    
}
}
