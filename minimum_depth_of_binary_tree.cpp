/**
 * Definition for binary tree
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode(int x) : val(x), left(NULL), right(NULL) {}
 * };
 */
class Solution {
public:

    
    int minDepth(TreeNode *root) {
        if(!root) return 0;
       
        
        int left = minDepth(root->left);
        int right = minDepth(root->right);
        
        if (0 == left && 0 == right)
            return 1;
            
        if (0 == left || 0 == right)
            return max(left, right) + 1;
            
        return min(left, right) + 1;
    }
};
