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
    TreeNode *upsideDownBinaryTree(TreeNode *root) {
        return dfsBottomUp(root,NULL);
    }
    
    TreeNode *dfsBottomUp(TreeNode* p, TreeNode* parent) {
        if(!p) return parent;
        TreeNode* root = dfsBottomUp(p->left, p);
        p->left = (!parent)? parent: parent->right;
        p->right = parent;
        return root;
    }
    
};
