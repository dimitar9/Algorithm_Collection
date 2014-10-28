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
    vector<vector<int> > levelOrderBottom(TreeNode *root) {
        if (!root) {return vector<vector<int> >();}
        vector<pair<TreeNode*,int> > q;
        int lev=1;
        int count=0;
        q.push_back(make_pair(root,lev));
         
        while (count<q.size()){
            TreeNode *node = q[count].first;
            lev = q[count].second;
            if (node->left){ q.push_back(make_pair(node->left,lev+1));}
            if (node->right){ q.push_back(make_pair(node->right,lev+1));}
            count++;
        }
         
        vector<vector<int> > res(lev, vector<int>());
        for (int i=0;i<q.size();i++){
            res[lev-q[i].second].push_back(q[i].first->val);
        }
         
        return res;
    }
};
