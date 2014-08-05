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
    void inOrder(TreeNode* root, int &pre, bool &res){
        if (!root || !res ){return;}
        inOrder(root->left,pre,res);
        if (pre>=root->val){
            res = false; return;
        }else{
            pre = root->val;
        }
        inOrder(root->right,pre,res);
    }
 
    bool minmax(TreeNode* root, int max, int min){
        if (!root){return true;}
        if (root->val>=max || root->val <=min){
            return false;
        }else{
            return minmax(root->left,root->val,min) && minmax(root->right, max, root->val);
        }
    }
 
    bool isValidBST(TreeNode *root) {
        if (!root){return true;}
        //Method 1
        //int pre = INT_MIN;
        //bool res=true;
        //inOrder(root,pre,res);
        //return res;
         
        //Method2
        return minmax(root,INT_MAX,INT_MIN);
    }
};
