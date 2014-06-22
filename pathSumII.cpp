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
    vector<vector<int> > allsol;
    vector<int> sol;
    void findSol(TreeNode* root, int sum){
        if ( (root->left==NULL) && (root->right==NULL) && (sum-root->val==0) ) {
            sol.push_back(root->val);
            allsol.push_back(sol);
            return;   
        }
        sol.push_back(root->val);
        if (root->left !=NULL){
            findSol(root->left, sum-root->val);
            sol.pop_back();
        }
        if (root->right!=NULL){
        findSol(root->right, sum-root->val);   
        sol.pop_back();
        }
         
    }
     
 
    vector<vector<int> > pathSum(TreeNode *root, int sum) {
        // Start typing your C/C++ solution below
        // DO NOT write int main() function
        sol.clear();
        allsol.clear();
        if (root==NULL) {return allsol;}
        findSol(root, sum);
        return allsol;
    }
};
