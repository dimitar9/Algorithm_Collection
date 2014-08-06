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
    int dfs(TreeNode* root, int currSum, int& res) {
        if (!root) {
            return res;
        } else {
            if  ((root->left == NULL) && ( root->right == NULL) ) {
                res += currSum * 10 + root->val;
            }
              currSum = currSum * 10 + root->val; //IMPORTANT. CANNOT DO THIS TWICE!
            if (root->left) {
              
                dfs(root->left,currSum,res);
            }
            if (root->right) {
               
                dfs(root->right,currSum,res);
            }
        }
    }
    int sumNumbers(TreeNode *root) {
        if(!root) return 0;
        int res =0;
        dfs(root,0,res);
        return res;
    }
};
