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
    bool hasPathSum(TreeNode *root, int sum) {
        if (!root) return false;
        if ((root->val == sum) && (!root->left )  && (!root->right )) return true;
        if ((!root->left) && (!root->right)) return false;
        if (hasPathSum(root->left,sum-root->val)) return true;
        if (hasPathSum(root->right,sum-root->val)) return true;
        
    }
};
