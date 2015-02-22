public class Solution {
    public void flatten(TreeNode root) {  
        while (root != null) {  
            if (root.left != null) {  
                TreeNode p = root.left;  
                while (p.right ) {  
                    p = p.right;  
                }  
                p.right = root.right;  
                root.right = root.left;  
                root.left = null;  
            }  
            root = root.right;  
        }  
    } 
}
