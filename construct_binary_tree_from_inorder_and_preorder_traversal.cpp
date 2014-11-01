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
    TreeNode* ct(vector<int>& preorder, vector<int> &inorder, int pst, int ist, int ied) {
        if(ist > ied) return NULL;
        int mid = 0;
        TreeNode* root = new TreeNode(preorder[pst]);
        for(int i = ist; i <= ied; i++){
            if(preorder[pst] == inorder[i])
            {    mid = i;break;}
        }
        root->left = ct(preorder, inorder,pst+1 , ist,mid-1 ); // pst+1 !!! easy for forget
        root->right = ct(preorder, inorder,pst+(mid-ist+1) , mid+1, ied);
        return root;
        
    }
    TreeNode *buildTree(vector<int> &preorder, vector<int> &inorder) {
        if (preorder.size()==0) return NULL;
        return ct(preorder, inorder,0, 0, inorder.size()-1);
        
    }
};
