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
    vector<vector<int> > levelOrder(TreeNode *root) {
        vector<vector<int> > res; //result vector
        queue<pair<TreeNode*,int> > q; //travseral queue
        vector<int> res_tmp; // level vector
         
        if (!root){return res;}
        q.push(make_pair(root,1)); //push the root into the queue
        int level=1; //previous level
        while (!q.empty()){
            pair<TreeNode*,int> tmp = q.front();
            q.pop();
            if (tmp.second!=level){ //if current element has a new level
                level = tmp.second;
                res.push_back(res_tmp); //push the level vector to result
                res_tmp.clear();  //clear the level vector to store the new level
            }
             
            res_tmp.push_back(tmp.first->val); //push the current value to the level vector
             
            if (tmp.first->left!=NULL){
                q.push(make_pair(tmp.first->left,tmp.second+1));
            }
            if (tmp.first->right!=NULL){
                q.push(make_pair(tmp.first->right,tmp.second+1));
            }
        }
        res.push_back(res_tmp); // the last level also needs to push into the result
        return res;
    }
};
