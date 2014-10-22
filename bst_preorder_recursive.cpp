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
    vector<int> ret; //THIS IS IMPORTANT, cannot put it inside funtion.
    vector<int> preorderTraversal(TreeNode *root) {
       
        if(root) {
            ret.push_back(root->val);
            preorderTraversal(root->left);
            preorderTraversal(root->right);
        }
        return  ret;
    }
};
